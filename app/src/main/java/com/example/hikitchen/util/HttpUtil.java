package com.example.hikitchen.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 杨凯-pc on 2019/3/13.
 */
//和服务器交互
public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
