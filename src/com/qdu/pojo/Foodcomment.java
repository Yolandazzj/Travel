package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Foodcomment {
    private int fCommentId;
    private String fCommentContent;
    private int fCommentScore;
    private Timestamp fCommentTime;

    @Id
    @Column(name = "FCommentID")
    public int getfCommentId() {
        return fCommentId;
    }

    public void setfCommentId(int fCommentId) {
        this.fCommentId = fCommentId;
    }

    @Basic
    @Column(name = "FCommentContent")
    public String getfCommentContent() {
        return fCommentContent;
    }

    public void setfCommentContent(String fCommentContent) {
        this.fCommentContent = fCommentContent;
    }

    @Basic
    @Column(name = "FCommentScore")
    public int getfCommentScore() {
        return fCommentScore;
    }

    public void setfCommentScore(int fCommentScore) {
        this.fCommentScore = fCommentScore;
    }

    @Basic
    @Column(name = "FCommentTime")
    public Timestamp getfCommentTime() {
        return fCommentTime;
    }

    public void setfCommentTime(Timestamp fCommentTime) {
        this.fCommentTime = fCommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foodcomment that = (Foodcomment) o;
        return fCommentId == that.fCommentId &&
                fCommentScore == that.fCommentScore &&
                Objects.equals(fCommentContent, that.fCommentContent) &&
                Objects.equals(fCommentTime, that.fCommentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fCommentId, fCommentContent, fCommentScore, fCommentTime);
    }
}
