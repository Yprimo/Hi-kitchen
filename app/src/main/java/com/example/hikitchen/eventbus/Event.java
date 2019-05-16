package com.example.hikitchen.eventbus;

/**
 * Created by Administrator on 2019/5/12.
 */
public class Event {

    private String mMsg;
    public Event(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
