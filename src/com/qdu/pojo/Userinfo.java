package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Userinfo {
    private String uid;
    private String uGender;
    private String uCity;
    private String uContact;
    private String uEmail;
    private String isBan;
    private String uPassword;
    private int uRank;

    @Id
    @Column(name = "UID")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "UGender")
    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    @Basic
    @Column(name = "UCity")
    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    @Basic
    @Column(name = "UContact")
    public String getuContact() {
        return uContact;
    }

    public void setuContact(String uContact) {
        this.uContact = uContact;
    }

    @Basic
    @Column(name = "UEmail")
    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Basic
    @Column(name = "IsBan")
    public String getIsBan() {
        return isBan;
    }

    public void setIsBan(String isBan) {
        this.isBan = isBan;
    }

    @Basic
    @Column(name = "UPassword")
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Basic
    @Column(name = "URank")
    public int getuRank() {
        return uRank;
    }

    public void setuRank(int uRank) {
        this.uRank = uRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userinfo userinfo = (Userinfo) o;
        return uRank == userinfo.uRank &&
                Objects.equals(uid, userinfo.uid) &&
                Objects.equals(uGender, userinfo.uGender) &&
                Objects.equals(uCity, userinfo.uCity) &&
                Objects.equals(uContact, userinfo.uContact) &&
                Objects.equals(uEmail, userinfo.uEmail) &&
                Objects.equals(isBan, userinfo.isBan) &&
                Objects.equals(uPassword, userinfo.uPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uGender, uCity, uContact, uEmail, isBan, uPassword, uRank);
    }
}
