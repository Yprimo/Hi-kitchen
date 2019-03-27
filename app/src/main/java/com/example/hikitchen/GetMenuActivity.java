package com.example.hikitchen;

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

public class GetMenuActivity extends AppCompatActivity {

    public static final String APPKEY = "d2c5e49da009dfdadebf957e66c40556";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_menu);
        RequestMenus();

    }

    public void RequestMenus() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 1);
        String menuUrl = "http://apis.juhe.cn/cook/index?key=" + APPKEY + "&cid=" + id + "&pn=0&rn=5";

        HttpUtil.sendOkHttpRequest(menuUrl, new okhttp3.Callback() {
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseText = response.body().string();
                final Result result = Utility.handleMenuResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null && "Success".equals(result.reason)) {
                            /*SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(GetMenuActivity.this).edit();
                            editor.putString("result", responseText);
                            editor.apply();*/

                            //Toast.makeText(GetMenuActivity.this, "获取菜谱信息成功", Toast.LENGTH_SHORT).show();
                            // Toast.makeText(GetMenuActivity.this,result.reason, Toast.LENGTH_SHORT).show();
                            //showMenuInfo(result);
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
    private void show(Result result){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_title_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter adapter = new MenuAdapter(result.menulist);
        recyclerView.setAdapter(adapter);
    }
}
