package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Routecomment {
    private int rCommentId;
    private String rCommentContent;
    private int rCommentScore;
    private Timestamp rCommentTime;

    @Id
    @Column(name = "RCommentID")
    public int getrCommentId() {
        return rCommentId;
    }

    public void setrCommentId(int rCommentId) {
        this.rCommentId = rCommentId;
    }

    @Basic
    @Column(name = "RCommentContent")
    public String getrCommentContent() {
        return rCommentContent;
    }

    public void setrCommentContent(String rCommentContent) {
        this.rCommentContent = rCommentContent;
    }

    @Basic
    @Column(name = "RCommentScore")
    public int getrCommentScore() {
        return rCommentScore;
    }

    public void setrCommentScore(int rCommentScore) {
        this.rCommentScore = rCommentScore;
    }

    @Basic
    @Column(name = "RCommentTime")
    public Timestamp getrCommentTime() {
        return rCommentTime;
    }

    public void setrCommentTime(Timestamp rCommentTime) {
        this.rCommentTime = rCommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routecomment that = (Routecomment) o;
        return rCommentId == that.rCommentId &&
                rCommentScore == that.rCommentScore &&
                Objects.equals(rCommentContent, that.rCommentContent) &&
                Objects.equals(rCommentTime, that.rCommentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rCommentId, rCommentContent, rCommentScore, rCommentTime);
    }
}
