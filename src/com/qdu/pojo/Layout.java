package com.qdu.pojo;
// Generated 2019-5-4 22:17:52 by Hibernate Tools 4.3.1



/**
 * Layout generated by hbm2java
 */
public class Layout  implements java.io.Serializable {


     private LayoutId id;
     private Hotel hotel;

    public Layout() {
    }

    public Layout(LayoutId id, Hotel hotel) {
       this.id = id;
       this.hotel = hotel;
    }
   
    public LayoutId getId() {
        return this.id;
    }
    
    public void setId(LayoutId id) {
        this.id = id;
    }
    public Hotel getHotel() {
        return this.hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }




}


