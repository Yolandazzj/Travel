package com.qdu.pojo;
// Generated 2019-4-18 21:40:29 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Essay generated by hbm2java
 */
public class Essay  implements java.io.Serializable {


     private Integer essayId;
     private City city;
     private Userinfo userinfo;
     private String etitle;
     private String econtent;
     private int escore;
     private Date etime;
     private Set essaycomments = new HashSet(0);

    public Essay() {
    }

	
    public Essay(City city, Userinfo userinfo, String etitle, String econtent, int escore, Date etime) {
        this.city = city;
        this.userinfo = userinfo;
        this.etitle = etitle;
        this.econtent = econtent;
        this.escore = escore;
        this.etime = etime;
    }
    public Essay(City city, Userinfo userinfo, String etitle, String econtent, int escore, Date etime, Set essaycomments) {
       this.city = city;
       this.userinfo = userinfo;
       this.etitle = etitle;
       this.econtent = econtent;
       this.escore = escore;
       this.etime = etime;
       this.essaycomments = essaycomments;
    }
   
    public Integer getEssayId() {
        return this.essayId;
    }
    
    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
    public String getEtitle() {
        return this.etitle;
    }
    
    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }
    public String getEcontent() {
        return this.econtent;
    }
    
    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }
    public int getEscore() {
        return this.escore;
    }
    
    public void setEscore(int escore) {
        this.escore = escore;
    }
    public Date getEtime() {
        return this.etime;
    }
    
    public void setEtime(Date etime) {
        this.etime = etime;
    }
    public Set getEssaycomments() {
        return this.essaycomments;
    }
    
    public void setEssaycomments(Set essaycomments) {
        this.essaycomments = essaycomments;
    }




}


