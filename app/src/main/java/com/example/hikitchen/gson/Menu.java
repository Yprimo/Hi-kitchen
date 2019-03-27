package com.example.hikitchen.gson;

import org.json.JSONArray;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨凯-pc on 2019/3/13.
 */

public class Menu {
    public int id;
    public String title;
    public String tags;//标签
    public String imtro;//简介
    public String ingredients;//原材料
    public String burden;//配料
    public String albums;
    public List<Steps>stepslist;
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
    public String getAlbums() {
        return albums;
    }
    public void setAlbums(String albums) {
        this.albums = albums;
    }
    public List<Steps> getSteps() {
        return stepslist;
    }
    public void setSteps(List<Steps>steps) {
        this.stepslist= steps;
    }

}
