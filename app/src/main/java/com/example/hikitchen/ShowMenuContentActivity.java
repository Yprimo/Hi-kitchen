package com.example.hikitchen;

import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hikitchen.gson.Menu;
import com.example.hikitchen.gson.Steps;

import java.io.Serializable;

public class ShowMenuContentActivity extends AppCompatActivity {
    private TextView titleMenu;
    private ImageView imageMenu;
    private TextView tagsMenu;
    private TextView imtroMenu;
    private TextView ingreMenu;
    private TextView burdenMenu;
    private LinearLayout stepsLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_content);
        Menu menu=(Menu)getIntent().getSerializableExtra("menu_data");//得到menu对象
        //初始化各控件
        titleMenu=(TextView)findViewById(R.id.title_menu);
        imageMenu=(ImageView)findViewById(R.id.image_menu);
        tagsMenu=(TextView)findViewById(R.id.tags_menu);
        imtroMenu=(TextView)findViewById(R.id.imtro_menu);
        ingreMenu=(TextView)findViewById(R.id.ingre_menu);
        burdenMenu=(TextView)findViewById(R.id.burden_menu);
        stepsLayout=(LinearLayout)findViewById(R.id.steps_layout);
        //给控件赋值
        titleMenu.setText(menu.title);
        Glide.with(this).load(menu.getAlbums()).into(imageMenu);
        tagsMenu.setText(menu.tags);
        imtroMenu.setText(menu.imtro);
        ingreMenu.setText(menu.ingredients);
        burdenMenu.setText(menu.burden);
        stepsLayout.removeAllViews();
        for(Steps steps:menu.stepslist){
            View view= LayoutInflater.from(this).inflate(R.layout.step_item,stepsLayout,false);
            ImageView stepImage=(ImageView)view.findViewById(R.id.step_image);
            TextView stepText=(TextView)view.findViewById(R.id.step_text);
            Glide.with(this).load(steps.img).into(stepImage);
            stepText.setText(steps.step);
            stepsLayout.addView(view);
        }
        stepsLayout.setVisibility(View.VISIBLE);
    }
}
