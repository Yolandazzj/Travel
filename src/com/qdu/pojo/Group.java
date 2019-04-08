package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Group {
    private int gid;
    private Timestamp gTime;
    private double gPrice;
    private int gQuatity;
    private Timestamp gEndTime;
    private String gContent;

    @Id
    @Column(name = "GID")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "GTime")
    public Timestamp getgTime() {
        return gTime;
    }

    public void setgTime(Timestamp gTime) {
        this.gTime = gTime;
    }

    @Basic
    @Column(name = "GPrice")
    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    @Basic
    @Column(name = "GQuatity")
    public int getgQuatity() {
        return gQuatity;
    }

    public void setgQuatity(int gQuatity) {
        this.gQuatity = gQuatity;
    }

    @Basic
    @Column(name = "GEndTime")
    public Timestamp getgEndTime() {
        return gEndTime;
    }

    public void setgEndTime(Timestamp gEndTime) {
        this.gEndTime = gEndTime;
    }

    @Basic
    @Column(name = "GContent")
    public String getgContent() {
        return gContent;
    }

    public void setgContent(String gContent) {
        this.gContent = gContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return gid == group.gid &&
                Double.compare(group.gPrice, gPrice) == 0 &&
                gQuatity == group.gQuatity &&
                Objects.equals(gTime, group.gTime) &&
                Objects.equals(gEndTime, group.gEndTime) &&
                Objects.equals(gContent, group.gContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, gTime, gPrice, gQuatity, gEndTime, gContent);
    }
}
