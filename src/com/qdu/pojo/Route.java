package com.qdu.pojo;
// Generated 2019-4-18 21:40:29 by Hibernate Tools 4.3.1




import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Route generated by hbm2java
 */

public class Route  implements java.io.Serializable {


     private Integer routeId;
     private Agency agency;
     @JsonIgnore
     private City city;
     private String routeName;
     private String routeContent;
     private int routeDay;
     private int routeScore;
     private float routePrice;
     private String routeImage;
     private Date routeStartDay;
     private Set routeordersesForRouteId = new HashSet(0);
     private Set routecomments = new HashSet(0);
     private Set routeordersesForRouteName = new HashSet(0);

    public Route() {
    }

	
    public Route(Agency agency, City city, String routeName, String routeContent, int routeDay, int routeScore, float routePrice, Date routeStartDay) {
        this.agency = agency;
        this.city = city;
        this.routeName = routeName;
        this.routeContent = routeContent;
        this.routeDay = routeDay;
        this.routeScore = routeScore;
        this.routePrice = routePrice;
        this.routeStartDay = routeStartDay;
    }
    public Route(Agency agency, City city, String routeName, String routeContent, int routeDay, int routeScore, float routePrice, String routeImage, Date routeStartDay, Set routeordersesForRouteId, Set routecomments, Set routeordersesForRouteName) {
       this.agency = agency;
       this.city = city;
       this.routeName = routeName;
       this.routeContent = routeContent;
       this.routeDay = routeDay;
       this.routeScore = routeScore;
       this.routePrice = routePrice;
       this.routeImage = routeImage;
       this.routeStartDay = routeStartDay;
       this.routeordersesForRouteId = routeordersesForRouteId;
       this.routecomments = routecomments;
       this.routeordersesForRouteName = routeordersesForRouteName;
    }
   
    public Integer getRouteId() {
        return this.routeId;
    }
    
    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
    public Agency getAgency() {
        return this.agency;
    }
    
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public String getRouteName() {
        return this.routeName;
    }
    
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    public String getRouteContent() {
        return this.routeContent;
    }
    
    public void setRouteContent(String routeContent) {
        this.routeContent = routeContent;
    }
    public int getRouteDay() {
        return this.routeDay;
    }
    
    public void setRouteDay(int routeDay) {
        this.routeDay = routeDay;
    }
    public int getRouteScore() {
        return this.routeScore;
    }
    
    public void setRouteScore(int routeScore) {
        this.routeScore = routeScore;
    }
    public float getRoutePrice() {
        return this.routePrice;
    }
    
    public void setRoutePrice(float routePrice) {
        this.routePrice = routePrice;
    }
    public String getRouteImage() {
        return this.routeImage;
    }
    
    public void setRouteImage(String routeImage) {
        this.routeImage = routeImage;
    }
    public Date getRouteStartDay() {
        return this.routeStartDay;
    }
    
    public void setRouteStartDay(Date routeStartDay) {
        this.routeStartDay = routeStartDay;
    }
    public Set getRouteordersesForRouteId() {
        return this.routeordersesForRouteId;
    }
    
    public void setRouteordersesForRouteId(Set routeordersesForRouteId) {
        this.routeordersesForRouteId = routeordersesForRouteId;
    }
    public Set getRoutecomments() {
        return this.routecomments;
    }
    
    public void setRoutecomments(Set routecomments) {
        this.routecomments = routecomments;
    }
    public Set getRouteordersesForRouteName() {
        return this.routeordersesForRouteName;
    }
    
    public void setRouteordersesForRouteName(Set routeordersesForRouteName) {
        this.routeordersesForRouteName = routeordersesForRouteName;
    }




}


