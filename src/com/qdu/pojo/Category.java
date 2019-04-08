package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Category {
    private int fCategoryId;
    private String fCategoryName;

    @Id
    @Column(name = "FCategoryID")
    public int getfCategoryId() {
        return fCategoryId;
    }

    public void setfCategoryId(int fCategoryId) {
        this.fCategoryId = fCategoryId;
    }

    @Basic
    @Column(name = "FCategoryName")
    public String getfCategoryName() {
        return fCategoryName;
    }

    public void setfCategoryName(String fCategoryName) {
        this.fCategoryName = fCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return fCategoryId == category.fCategoryId &&
                Objects.equals(fCategoryName, category.fCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fCategoryId, fCategoryName);
    }
}
