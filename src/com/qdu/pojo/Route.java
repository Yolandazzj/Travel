package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Route {
    private int routeId;
    private String routeName;
    private String routeContent;
    private int routeDay;
    private int routeScore;
    private double routePrice;
    private String routeImage;
    private Timestamp routeStartDay;

    @Id
    @Column(name = "RouteID")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "RouteName")
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Basic
    @Column(name = "RouteContent")
    public String getRouteContent() {
        return routeContent;
    }

    public void setRouteContent(String routeContent) {
        this.routeContent = routeContent;
    }

    @Basic
    @Column(name = "RouteDay")
    public int getRouteDay() {
        return routeDay;
    }

    public void setRouteDay(int routeDay) {
        this.routeDay = routeDay;
    }

    @Basic
    @Column(name = "RouteScore")
    public int getRouteScore() {
        return routeScore;
    }

    public void setRouteScore(int routeScore) {
        this.routeScore = routeScore;
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
    @Column(name = "RouteImage")
    public String getRouteImage() {
        return routeImage;
    }

    public void setRouteImage(String routeImage) {
        this.routeImage = routeImage;
    }

    @Basic
    @Column(name = "RouteStartDay")
    public Timestamp getRouteStartDay() {
        return routeStartDay;
    }

    public void setRouteStartDay(Timestamp routeStartDay) {
        this.routeStartDay = routeStartDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return routeId == route.routeId &&
                routeDay == route.routeDay &&
                routeScore == route.routeScore &&
                Double.compare(route.routePrice, routePrice) == 0 &&
                Objects.equals(routeName, route.routeName) &&
                Objects.equals(routeContent, route.routeContent) &&
                Objects.equals(routeImage, route.routeImage) &&
                Objects.equals(routeStartDay, route.routeStartDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, routeName, routeContent, routeDay, routeScore, routePrice, routeImage, routeStartDay);
    }
}
