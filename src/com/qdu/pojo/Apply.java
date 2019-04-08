package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Apply {
    private String contact;
    private String gState;

    @Basic
    @Column(name = "Contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "GState")
    public String getgState() {
        return gState;
    }

    public void setgState(String gState) {
        this.gState = gState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apply apply = (Apply) o;
        return Objects.equals(contact, apply.contact) &&
                Objects.equals(gState, apply.gState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, gState);
    }
}
