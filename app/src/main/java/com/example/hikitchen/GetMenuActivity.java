package com.example.hikitchen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.hikitchen.R;
import com.example.hikitchen.adapter.MenuAdapter;
import com.example.hikitchen.gson.Menu;
import com.example.hikitchen.gson.Result;
import com.example.hikitchen.gson.Steps;
import com.example.hikitchen.util.HttpUtil;
import com.example.hikitchen.util.Utility;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
//菜谱列表
public class GetMenuActivity extends AppCompatActivity {

    public static final String APPKEY = "d2c5e49da009dfdadebf957e66c40556";//申请到的菜谱接口key
    static int id1=-1;//判断是否是上一次刚
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_menu);
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 1);//从kindsfragment得到查询id;
        String menuUrl = "http://apis.juhe.cn/cook/index?key=" + APPKEY + "&cid=" + id + "&pn=0&rn=30";
        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
        String resultString=prefs.getString("result",null);//缓存中取出result
        if(resultString!=null&&id1==id){//如果缓存中有数据并且是上一次查询过的直接从缓存中取数
            Result result = Utility.handleMenuResponse(resultString);
            show(result);
        }
        else{//否则去服务器接口查询
            id1=id;
            RequestMenus(menuUrl);
        }
    }
    public void RequestMenus(String menuUrl) {
        HttpUtil.sendOkHttpRequest(menuUrl, new okhttp3.Callback() {
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseText = response.body().string();
                final Result result = Utility.handleMenuResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null && "Success".equals(result.reason)) {
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(GetMenuActivity.this).edit();
                            editor.putString("result", responseText);
                            editor.apply();//缓存
                            show(result);
                            Toast.makeText(GetMenuActivity.this, "获取菜谱信息成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GetMenuActivity.this, "获取菜谱信息失败1", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(GetMenuActivity.this, "获取菜谱信息失败2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    private void show(Result result){//利用适配器显示数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_title_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter adapter = new MenuAdapter(GetMenuActivity.this,result.menulist);
        recyclerView.setAdapter(adapter);
    }
}
