package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Agency {
    private int agencyId;
    private String agencyName;
    private String agencyContact;
    private int agencyScore;
    private String agencyContent;

    @Id
    @Column(name = "AgencyID")
    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Basic
    @Column(name = "AgencyName")
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Basic
    @Column(name = "AgencyContact")
    public String getAgencyContact() {
        return agencyContact;
    }

    public void setAgencyContact(String agencyContact) {
        this.agencyContact = agencyContact;
    }

    @Basic
    @Column(name = "AgencyScore")
    public int getAgencyScore() {
        return agencyScore;
    }

    public void setAgencyScore(int agencyScore) {
        this.agencyScore = agencyScore;
    }

    @Basic
    @Column(name = "AgencyContent")
    public String getAgencyContent() {
        return agencyContent;
    }

    public void setAgencyContent(String agencyContent) {
        this.agencyContent = agencyContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return agencyId == agency.agencyId &&
                agencyScore == agency.agencyScore &&
                Objects.equals(agencyName, agency.agencyName) &&
                Objects.equals(agencyContact, agency.agencyContact) &&
                Objects.equals(agencyContent, agency.agencyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencyId, agencyName, agencyContact, agencyScore, agencyContent);
    }
}
