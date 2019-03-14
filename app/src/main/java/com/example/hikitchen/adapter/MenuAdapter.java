package com.example.hikitchen.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.example.hikitchen.gson.Menu;

import java.util.List;

/**
 * Created by 杨凯-pc on 2019/3/14.
 */

public class MenuAdapter extends ArrayAdapter<Menu> {

    private int resourceId;
    public MenuAdapter(Context context, int textViewResourceId,List<Menu> objects) {
        super(context,textViewResourceId,objects );
        resourceId=textViewResourceId;
    }
}
