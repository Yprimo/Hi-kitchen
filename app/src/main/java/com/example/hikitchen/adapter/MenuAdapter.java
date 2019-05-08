package com.example.hikitchen.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hikitchen.GetMenuActivity;
import com.example.hikitchen.R;
import com.example.hikitchen.ShowMenuContentActivity;
import com.example.hikitchen.gson.Menu;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨凯-pc on 2019/3/14.
 */
//适配器
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private int resourceId;
    private List<Menu> mMenuList = new ArrayList<>();
    Context ctx;
    static class ViewHolder extends RecyclerView.ViewHolder {
        View menuView;
        ImageView menuImage;
        TextView menutitle;
        TextView menuingre;
        TextView menuburden;
        public ViewHolder(View view) {
            super(view);
            menuView=view;
            //初始化各控件
            menuImage = (ImageView) view.findViewById(R.id.menu_image);//菜谱标签图片
            menutitle = (TextView) view.findViewById(R.id.menu_title);//菜谱名字
            menuingre = (TextView) view.findViewById(R.id.menu_ingre);//原材料
            menuburden=(TextView)view.findViewById(R.id.menu_burden);//配料

        }
    }

    public MenuAdapter(Context context,List<Menu> menuList) {
        ctx=context;
        mMenuList = menuList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.menuView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                Menu menu=mMenuList.get(position);
                Intent intent = new Intent(v.getContext(), ShowMenuContentActivity.class);
                intent.putExtra("menu_data",menu);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override


    public void onBindViewHolder(ViewHolder holder, int position) {//对recycleview进行赋值
        Menu menu = mMenuList.get(position);
        Glide.with(ctx).load(menu.getAlbums()).into(holder.menuImage);//利用glide加载图片
        holder.menutitle.setText(menu.getTitle());
        holder.menuingre.setText(menu.getIngredients());
        holder.menuburden.setText(menu.getBurden());
    }

    public int getItemCount() {
        return mMenuList.size();
    }//一共有多少子项

}


