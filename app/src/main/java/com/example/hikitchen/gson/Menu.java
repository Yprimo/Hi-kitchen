package com.example.hikitchen.gson;

import java.util.ArrayList;

/**
 * Created by 杨凯-pc on 2019/3/13.
 */

public class Menu {
    public int id;
    public String title;
    public String tags;
    public String imtro;
    public String ingredients;
    public String burden;
    public ArrayList albumslist;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTags(){
        return tags;
    }
    public void setTags(String tags){
        this.tags=tags;
    }
    public String getImtro(){
        return imtro;
    }
    public void setImtro(String imtro){
        this.imtro=imtro;
    }
    public String getIngredients(){
        return ingredients;
    }
    public void setIngredients(String ingredients){
        this.ingredients=ingredients;
    }
    public String getBurden() {
        return burden;
    }
    public void setBurden(String burden) {
        this.burden = burden;
    }

    public ArrayList getAlbumslist() {
        return albumslist;
    }

    public void setAlbumslist(ArrayList albumslist) {
        this.albumslist = albumslist;
    }
}
