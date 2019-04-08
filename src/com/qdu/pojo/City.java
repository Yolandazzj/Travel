package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {
    private int cityId;
    private String cityName;
    private int cityScore;
    private String cityImage;

    @Id
    @Column(name = "CityID")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CityName")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "CityScore")
    public int getCityScore() {
        return cityScore;
    }

    public void setCityScore(int cityScore) {
        this.cityScore = cityScore;
    }

    @Basic
    @Column(name = "CityImage")
    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId &&
                cityScore == city.cityScore &&
                Objects.equals(cityName, city.cityName) &&
                Objects.equals(cityImage, city.cityImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, cityScore, cityImage);
    }
}
