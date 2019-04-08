package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hotelorders {
    private int hotelOrderId;
    private String hotelName;
    private double hotelPrice;
    private int orderDay;
    private String contact;
    private String orderName;
    private int orderPeople;

    @Id
    @Column(name = "HotelOrderID")
    public int getHotelOrderId() {
        return hotelOrderId;
    }

    public void setHotelOrderId(int hotelOrderId) {
        this.hotelOrderId = hotelOrderId;
    }

    @Basic
    @Column(name = "HotelName")
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Basic
    @Column(name = "HotelPrice")
    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    @Basic
    @Column(name = "OrderDay")
    public int getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(int orderDay) {
        this.orderDay = orderDay;
    }

    @Basic
    @Column(name = "Contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "OrderName")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "OrderPeople")
    public int getOrderPeople() {
        return orderPeople;
    }

    public void setOrderPeople(int orderPeople) {
        this.orderPeople = orderPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotelorders that = (Hotelorders) o;
        return hotelOrderId == that.hotelOrderId &&
                Double.compare(that.hotelPrice, hotelPrice) == 0 &&
                orderDay == that.orderDay &&
                orderPeople == that.orderPeople &&
                Objects.equals(hotelName, that.hotelName) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(orderName, that.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelOrderId, hotelName, hotelPrice, orderDay, contact, orderName, orderPeople);
    }
}
