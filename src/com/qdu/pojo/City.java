package com.qdu.pojo;
// Generated 2019-4-9 19:55:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * City generated by hbm2java
 */
public class City  implements java.io.Serializable {


     private int cityId;
     private Province province;
     private String cityName;
     private int cityScore;
     private String cityImage;
     private Set routecomments = new HashSet(0);
     private Set groups = new HashSet(0);
     private Set routes = new HashSet(0);
     private Set essays = new HashSet(0);
     private Set scenes = new HashSet(0);
     private Set foodstores = new HashSet(0);

    public City() {
    }

	
    public City(int cityId, Province province, String cityName, int cityScore, String cityImage) {
        this.cityId = cityId;
        this.province = province;
        this.cityName = cityName;
        this.cityScore = cityScore;
        this.cityImage = cityImage;
    }
    public City(int cityId, Province province, String cityName, int cityScore, String cityImage, Set routecomments, Set groups, Set routes, Set essays, Set scenes, Set foodstores) {
       this.cityId = cityId;
       this.province = province;
       this.cityName = cityName;
       this.cityScore = cityScore;
       this.cityImage = cityImage;
       this.routecomments = routecomments;
       this.groups = groups;
       this.routes = routes;
       this.essays = essays;
       this.scenes = scenes;
       this.foodstores = foodstores;
    }
   
    public int getCityId() {
        return this.cityId;
    }
    
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public Province getProvince() {
        return this.province;
    }
    
    public void setProvince(Province province) {
        this.province = province;
    }
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public int getCityScore() {
        return this.cityScore;
    }
    
    public void setCityScore(int cityScore) {
        this.cityScore = cityScore;
    }
    public String getCityImage() {
        return this.cityImage;
    }
    
    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }
    public Set getRoutecomments() {
        return this.routecomments;
    }
    
    public void setRoutecomments(Set routecomments) {
        this.routecomments = routecomments;
    }
    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
    public Set getRoutes() {
        return this.routes;
    }
    
    public void setRoutes(Set routes) {
        this.routes = routes;
    }
    public Set getEssays() {
        return this.essays;
    }
    
    public void setEssays(Set essays) {
        this.essays = essays;
    }
    public Set getScenes() {
        return this.scenes;
    }
    
    public void setScenes(Set scenes) {
        this.scenes = scenes;
    }
    public Set getFoodstores() {
        return this.foodstores;
    }
    
    public void setFoodstores(Set foodstores) {
        this.foodstores = foodstores;
    }




}


