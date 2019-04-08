package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Foodinfo {
    private int fid;
    private String fName;
    private int fScore;
    private String fImage;
    private double fPrice;

    @Id
    @Column(name = "FID")
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "FName")
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "FScore")
    public int getfScore() {
        return fScore;
    }

    public void setfScore(int fScore) {
        this.fScore = fScore;
    }

    @Basic
    @Column(name = "FImage")
    public String getfImage() {
        return fImage;
    }

    public void setfImage(String fImage) {
        this.fImage = fImage;
    }

    @Basic
    @Column(name = "FPrice")
    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foodinfo foodinfo = (Foodinfo) o;
        return fid == foodinfo.fid &&
                fScore == foodinfo.fScore &&
                Double.compare(foodinfo.fPrice, fPrice) == 0 &&
                Objects.equals(fName, foodinfo.fName) &&
                Objects.equals(fImage, foodinfo.fImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, fName, fScore, fImage, fPrice);
    }
}
