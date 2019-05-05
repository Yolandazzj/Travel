package com.qdu.pojo;
// Generated 2019-5-4 22:17:52 by Hibernate Tools 4.3.1



/**
 * Hotelorders generated by hbm2java
 */
public class Hotelorders  implements java.io.Serializable {


     private Integer hotelOrderId;
     private Hotel hotel;
     private Userinfo userinfo;
     private String hotelName;
     private float hotelPrice;
     private int orderDay;
     private String contact;
     private String orderName;
     private int orderPeople;

    public Hotelorders() {
    }

	
    public Hotelorders(Hotel hotel, String hotelName, float hotelPrice, int orderDay, String contact, String orderName, int orderPeople) {
        this.hotel = hotel;
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.orderDay = orderDay;
        this.contact = contact;
        this.orderName = orderName;
        this.orderPeople = orderPeople;
    }
    public Hotelorders(Hotel hotel, Userinfo userinfo, String hotelName, float hotelPrice, int orderDay, String contact, String orderName, int orderPeople) {
       this.hotel = hotel;
       this.userinfo = userinfo;
       this.hotelName = hotelName;
       this.hotelPrice = hotelPrice;
       this.orderDay = orderDay;
       this.contact = contact;
       this.orderName = orderName;
       this.orderPeople = orderPeople;
    }
   
    public Integer getHotelOrderId() {
        return this.hotelOrderId;
    }
    
    public void setHotelOrderId(Integer hotelOrderId) {
        this.hotelOrderId = hotelOrderId;
    }
    public Hotel getHotel() {
        return this.hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
    public String getHotelName() {
        return this.hotelName;
    }
    
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public float getHotelPrice() {
        return this.hotelPrice;
    }
    
    public void setHotelPrice(float hotelPrice) {
        this.hotelPrice = hotelPrice;
    }
    public int getOrderDay() {
        return this.orderDay;
    }
    
    public void setOrderDay(int orderDay) {
        this.orderDay = orderDay;
    }
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getOrderName() {
        return this.orderName;
    }
    
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public int getOrderPeople() {
        return this.orderPeople;
    }
    
    public void setOrderPeople(int orderPeople) {
        this.orderPeople = orderPeople;
    }




}


