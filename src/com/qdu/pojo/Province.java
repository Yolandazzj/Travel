package com.qdu.pojo;
// Generated 2019-4-18 21:40:29 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Province generated by hbm2java
 */
public class Province  implements java.io.Serializable {


     private Integer provinceId;
     private String cityName;
     private Set cities = new HashSet(0);

    public Province() {
    }

	
    public Province(String cityName) {
        this.cityName = cityName;
    }
    public Province(String cityName, Set cities) {
       this.cityName = cityName;
       this.cities = cities;
    }
   
    public Integer getProvinceId() {
        return this.provinceId;
    }
    
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public Set getCities() {
        return this.cities;
    }
    
    public void setCities(Set cities) {
        this.cities = cities;
    }




}


