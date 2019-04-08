package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Essay {
    private int essayId;
    private String eTitle;
    private String eContent;
    private int eScore;
    private Timestamp eTime;

    @Id
    @Column(name = "EssayID")
    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    @Basic
    @Column(name = "ETitle")
    public String geteTitle() {
        return eTitle;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    @Basic
    @Column(name = "EContent")
    public String geteContent() {
        return eContent;
    }

    public void seteContent(String eContent) {
        this.eContent = eContent;
    }

    @Basic
    @Column(name = "EScore")
    public int geteScore() {
        return eScore;
    }

    public void seteScore(int eScore) {
        this.eScore = eScore;
    }

    @Basic
    @Column(name = "ETime")
    public Timestamp geteTime() {
        return eTime;
    }

    public void seteTime(Timestamp eTime) {
        this.eTime = eTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Essay essay = (Essay) o;
        return essayId == essay.essayId &&
                eScore == essay.eScore &&
                Objects.equals(eTitle, essay.eTitle) &&
                Objects.equals(eContent, essay.eContent) &&
                Objects.equals(eTime, essay.eTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(essayId, eTitle, eContent, eScore, eTime);
    }
}
