package com.example.hikitchen;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.support.v4.app.FragmentTransaction;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_home,rb_commuity,rb_kinds,rb_my;
    private Drawable drawables[];
    private Rect r;

    //Fragment Object
    private MyFragment fg1, fg2, fg3, fg4;
    private FragmentManager fManager;
    private RadioButton rb[];
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义RadioButton数组用来装RadioButton，改变drawableTop大小
        rb = new RadioButton[4];
        //将RadioButton装进数组中
        rb[0] = (RadioButton) findViewById(R.id.rb_home);
        rb[1] = (RadioButton) findViewById(R.id.rb_community);
        rb[2] = (RadioButton) findViewById(R.id.rb_kinds);
        rb[3] = (RadioButton) findViewById(R.id.rb_my);
        //for循环对每一个RadioButton图片进行缩放
        for (int i = 0; i < rb.length; i++) {
            //挨着给每个RadioButton加入drawable限制边距以控制显示大小
            drawables = rb[i].getCompoundDrawables();
            //获取drawables，2/5表示图片要缩小的比例
            r = new Rect(0, 0, drawables[1].getMinimumWidth() * 2 / 5, drawables[1].getMinimumHeight() * 2 / 5);
            //定义一个Rect边界
            drawables[1].setBounds(r);
            //给每一个RadioButton设置图片大小
            rb[i].setCompoundDrawables(null, drawables[1], null, null);
        }


        fManager = getSupportFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_commuity=(RadioButton) findViewById(R.id.rb_community);
        rb_kinds=(RadioButton) findViewById(R.id.rb_kinds);
        rb_my=(RadioButton) findViewById(R.id.rb_my);
        rb_home.setChecked(true);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId) {
            case R.id.rb_home:
                if (fg1 == null) {
                    fg1 = MyFragment.newInstance("第一个Fragment");
                    fTransaction.add(R.id.ly_content, fg1);
                } else {
                    fTransaction.show(fg1);
                }
                rb_home.setSelected(true);
                break;
            case R.id.rb_community:
                if (fg2 == null) {
                    fg2 = MyFragment.newInstance("第二个Fragment");

                    fTransaction.add(R.id.ly_content, fg2);
                } else {
                    fTransaction.show(fg2);
                }
                rb_commuity.setSelected(true);
                break;
            case R.id.rb_kinds:
                if (fg3 == null) {
                    fg3 = MyFragment.newInstance("第三个Fragment");

                    fTransaction.add(R.id.ly_content, fg3);
                } else {
                    fTransaction.show(fg3);
                }
                rb_kinds.setSelected(true);
                break;
            case R.id.rb_my:
                if (fg4 == null) {
                    fg4 = MyFragment.newInstance("第四个Fragment");

                    fTransaction.add(R.id.ly_content, fg4);
                } else {
                    fTransaction.show(fg4);
                }
                rb_my.setSelected(true);
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);
        if (fg4 != null) fragmentTransaction.hide(fg4);
        rb_home.setSelected(false);
        rb_commuity.setSelected(false);
        rb_kinds.setSelected(false);
        rb_my.setSelected(false);
    }


}
