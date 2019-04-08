package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hotel {
    private int hotelId;
    private String hotelName;
    private double hotelPrice;
    private String hotelLevel;
    private int hotelScore;
    private String hotelImage;

    @Id
    @Column(name = "HotelID")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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
    @Column(name = "HotelLevel")
    public String getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(String hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    @Basic
    @Column(name = "HotelScore")
    public int getHotelScore() {
        return hotelScore;
    }

    public void setHotelScore(int hotelScore) {
        this.hotelScore = hotelScore;
    }

    @Basic
    @Column(name = "HotelImage")
    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                Double.compare(hotel.hotelPrice, hotelPrice) == 0 &&
                hotelScore == hotel.hotelScore &&
                Objects.equals(hotelName, hotel.hotelName) &&
                Objects.equals(hotelLevel, hotel.hotelLevel) &&
                Objects.equals(hotelImage, hotel.hotelImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, hotelName, hotelPrice, hotelLevel, hotelScore, hotelImage);
    }
}
