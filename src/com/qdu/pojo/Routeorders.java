package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Routeorders {
    private int routeOrderId;
    private double routePrice;
    private String contact;
    private String routeOrderName;
    private int routeOrderPeople;

    @Id
    @Column(name = "RouteOrderID")
    public int getRouteOrderId() {
        return routeOrderId;
    }

    public void setRouteOrderId(int routeOrderId) {
        this.routeOrderId = routeOrderId;
    }

    @Basic
    @Column(name = "RoutePrice")
    public double getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(double routePrice) {
        this.routePrice = routePrice;
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
    @Column(name = "RouteOrderName")
    public String getRouteOrderName() {
        return routeOrderName;
    }

    public void setRouteOrderName(String routeOrderName) {
        this.routeOrderName = routeOrderName;
    }

    @Basic
    @Column(name = "RouteOrderPeople")
    public int getRouteOrderPeople() {
        return routeOrderPeople;
    }

    public void setRouteOrderPeople(int routeOrderPeople) {
        this.routeOrderPeople = routeOrderPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routeorders that = (Routeorders) o;
        return routeOrderId == that.routeOrderId &&
                Double.compare(that.routePrice, routePrice) == 0 &&
                routeOrderPeople == that.routeOrderPeople &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(routeOrderName, that.routeOrderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeOrderId, routePrice, contact, routeOrderName, routeOrderPeople);
    }
}
