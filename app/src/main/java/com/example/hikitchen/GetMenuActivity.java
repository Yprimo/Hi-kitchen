package com.example.hikitchen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hikitchen.R;
import com.example.hikitchen.adapter.MenuAdapter;
import com.example.hikitchen.gson.Menu;
import java.util.ArrayList;
import java.util.List;

public class GetMenuActivity extends AppCompatActivity {

    public List<Menu> menuList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_menu);
        initMenus();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.menu_title_recycle_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MenuAdapter adapter=new MenuAdapter(menuList);
        recyclerView.setAdapter(adapter);

    }
    public void initMenus(){

    }
}
