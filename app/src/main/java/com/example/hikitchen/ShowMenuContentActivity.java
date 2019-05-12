
package com.example.hikitchen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hikitchen.gson.Menu;
import com.example.hikitchen.gson.Steps;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class ShowMenuContentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleMenu;
    private ImageView imageMenu;
    private TextView tagsMenu;
    private TextView imtroMenu;
    private TextView ingreMenu;
    private TextView burdenMenu;
    private LinearLayout stepsLayout;
    private ImageView imageBf;
    boolean isChanged = false;
    private Menu menu;
    private int i = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_content);

        initPermission();

        EventBus.getDefault().register(this);
        menu = (Menu) getIntent().getSerializableExtra("menu_data");//得到menu对象
        //初始化各控件
        titleMenu = (TextView) findViewById(R.id.title_menu);
        imageMenu = (ImageView) findViewById(R.id.image_menu);
        tagsMenu = (TextView) findViewById(R.id.tags_menu);
        imtroMenu = (TextView) findViewById(R.id.imtro_menu);
        ingreMenu = (TextView) findViewById(R.id.ingre_menu);
        burdenMenu = (TextView) findViewById(R.id.burden_menu);
        imageBf = (ImageView) findViewById(R.id.image_bf);
        imageBf.setOnClickListener(this);
        stepsLayout = (LinearLayout) findViewById(R.id.steps_layout);
        //给控件赋值
        titleMenu.setText(menu.title);
        Glide.with(this).load(menu.getAlbums()).into(imageMenu);
        tagsMenu.setText(menu.tags);
        imtroMenu.setText(menu.imtro);
        ingreMenu.setText(menu.ingredients);
        burdenMenu.setText(menu.burden);
        stepsLayout.removeAllViews();
        for (Steps steps : menu.stepslist) {
            View view = LayoutInflater.from(this).inflate(R.layout.step_item, stepsLayout, false);
            ImageView stepImage = (ImageView) view.findViewById(R.id.step_image);
            TextView stepText = (TextView) view.findViewById(R.id.step_text);
            Glide.with(this).load(steps.img).into(stepImage);
            stepText.setText(steps.step);
            stepsLayout.addView(view);
        }
        stepsLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_bf:
                i++;
                if (isChanged) {
                    imageBf.setImageDrawable(getResources().getDrawable(R.mipmap.tab_zt));
                    SpeakVoiceUtil.getInstance(getApplicationContext()).pause();
                } else {
                    imageBf.setImageDrawable(getResources().getDrawable(R.mipmap.tab_bf));
                    if (SpeakVoiceUtil.getInstance(getApplicationContext()).flag!=2) {
                     //    for (Steps steps : menu.stepslist) {
                      //       SpeakVoiceUtil.getInstance(getApplicationContext()).speak(steps.step);
                        SpeakVoiceUtil.getInstance(getApplicationContext()).batchSpeak(menu.stepslist);
                       //  }
                    } else {
                        SpeakVoiceUtil.getInstance(getApplicationContext()).resume();
                    }
                }
                isChanged = !isChanged;
                break;

        }
    }

    private void initPermission() {
        String permissions[] = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.MODIFY_AUDIO_SETTINGS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_SETTINGS,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            Object context;
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限.
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 1)
    public void onMessageEventMain(Event event){
        if(event.getMsg().equals("1000")) {
            imageBf.setImageDrawable(getResources().getDrawable(R.mipmap.tab_zt));
            isChanged = !isChanged;
            i=0;
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}



