package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Admininfo {
    private String adminId;
    private String adminPassword;

    @Id
    @Column(name = "AdminID")
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "AdminPassword")
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admininfo admininfo = (Admininfo) o;
        return Objects.equals(adminId, admininfo.adminId) &&
                Objects.equals(adminPassword, admininfo.adminPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminPassword);
    }
}
