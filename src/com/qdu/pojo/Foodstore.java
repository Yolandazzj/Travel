package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Foodstore {
    private int did;
    private String dName;
    private String dAddress;

    @Id
    @Column(name = "DID")
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "DName")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "DAddress")
    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foodstore foodstore = (Foodstore) o;
        return did == foodstore.did &&
                Objects.equals(dName, foodstore.dName) &&
                Objects.equals(dAddress, foodstore.dAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dName, dAddress);
    }
}
