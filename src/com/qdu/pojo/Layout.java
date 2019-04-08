package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Layout {
    private double layoutPrice;
    private String layoutImage;
    private String layoutSize;
    private String layoutBed;

    @Basic
    @Column(name = "LayoutPrice")
    public double getLayoutPrice() {
        return layoutPrice;
    }

    public void setLayoutPrice(double layoutPrice) {
        this.layoutPrice = layoutPrice;
    }

    @Basic
    @Column(name = "LayoutImage")
    public String getLayoutImage() {
        return layoutImage;
    }

    public void setLayoutImage(String layoutImage) {
        this.layoutImage = layoutImage;
    }

    @Basic
    @Column(name = "LayoutSize")
    public String getLayoutSize() {
        return layoutSize;
    }

    public void setLayoutSize(String layoutSize) {
        this.layoutSize = layoutSize;
    }

    @Basic
    @Column(name = "LayoutBed")
    public String getLayoutBed() {
        return layoutBed;
    }

    public void setLayoutBed(String layoutBed) {
        this.layoutBed = layoutBed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layout layout = (Layout) o;
        return Double.compare(layout.layoutPrice, layoutPrice) == 0 &&
                Objects.equals(layoutImage, layout.layoutImage) &&
                Objects.equals(layoutSize, layout.layoutSize) &&
                Objects.equals(layoutBed, layout.layoutBed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layoutPrice, layoutImage, layoutSize, layoutBed);
    }
}
