package com.example.hikitchen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hikitchen.R;
import com.example.hikitchen.gson.Menu;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨凯-pc on 2019/3/14.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private int resourceId;
    private List<Menu>mMenuList=new ArrayList<>();;
    static class ViewHolder extends RecyclerView.ViewHolder{
       // ImageView menuImage;
        TextView menutitle;
        public ViewHolder(View view){
            super(view);
       //     menuImage=(ImageView)view.findViewById(R.id.menu_image);
            menutitle=(TextView)view.findViewById(R.id.menu_title);

        }
    }
    public MenuAdapter(List<Menu>menuList) {
        mMenuList=menuList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
       ViewHolder holder=new ViewHolder(view);
       return holder;
   }

    @Override


    public void onBindViewHolder(ViewHolder holder, int position){
        Menu menu =mMenuList.get(position);
       // holder.menuImage.setImageResource(menu.getAlbums());
        holder.menutitle.setText(menu.getTitle());
    }
    public int getItemCount(){
        return mMenuList.size();
    }
}
