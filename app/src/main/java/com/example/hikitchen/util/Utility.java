package com.example.hikitchen.util;

import android.util.Log;

import com.example.hikitchen.gson.Menu;
import com.example.hikitchen.gson.Result;
import com.example.hikitchen.gson.Steps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 杨凯-pc on 2019/3/13.
 */
//解析json数据
public class Utility {
    public static Result handleMenuResponse(String response){
        try {
            Result result=new Result();
            result.menulist=new ArrayList<>();           //要初始化！！！
            //List<Issue> issues = new ArrayList<>();
           // List<Menu>menulist=new ArrayList<Menu>();
            JSONObject jsonObject = new JSONObject(response);
            result.error_code=jsonObject.getInt("error_code");
            result.reason=jsonObject.getString("reason");
            String result1 = jsonObject.getString("result");
            JSONObject jsonObject1 = new JSONObject(result1);
            JSONArray jsonArray = jsonObject1.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                Menu menu=new Menu();
                menu.stepslist=new ArrayList<>();          //要初始化
                JSONObject tree = jsonArray.getJSONObject(i);
                menu.id = tree.getInt("id");
                menu.title = tree.getString("title");
                menu.tags = tree.getString("tags");
                menu.imtro = tree.getString("imtro");
                menu.ingredients = tree.getString("ingredients");
                menu.burden = tree.getString("burden");
                JSONArray album = tree.optJSONArray("albums");
                menu.albums = album.getString(0);                   //图片地址
                JSONArray stepArray = tree.getJSONArray("steps");//菜谱步骤
                for (int j = 0; j < stepArray.length(); j++) {
                    JSONObject step =stepArray.getJSONObject(j);
                    Steps steps=new Steps();
                    steps.img = step.getString("img");
                    steps.step = step.getString("step");
                    menu.stepslist.add(steps);
                }
                result.menulist.add(menu);
            }
            return result;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
