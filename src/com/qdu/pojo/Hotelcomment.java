package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Hotelcomment {
    private int hCommentId;
    private String hCommentContent;
    private int hCommentScore;
    private Timestamp hCommentTime;

    @Id
    @Column(name = "HCommentID")
    public int gethCommentId() {
        return hCommentId;
    }

    public void sethCommentId(int hCommentId) {
        this.hCommentId = hCommentId;
    }

    @Basic
    @Column(name = "HCommentContent")
    public String gethCommentContent() {
        return hCommentContent;
    }

    public void sethCommentContent(String hCommentContent) {
        this.hCommentContent = hCommentContent;
    }

    @Basic
    @Column(name = "HCommentScore")
    public int gethCommentScore() {
        return hCommentScore;
    }

    public void sethCommentScore(int hCommentScore) {
        this.hCommentScore = hCommentScore;
    }

    @Basic
    @Column(name = "HCommentTime")
    public Timestamp gethCommentTime() {
        return hCommentTime;
    }

    public void sethCommentTime(Timestamp hCommentTime) {
        this.hCommentTime = hCommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotelcomment that = (Hotelcomment) o;
        return hCommentId == that.hCommentId &&
                hCommentScore == that.hCommentScore &&
                Objects.equals(hCommentContent, that.hCommentContent) &&
                Objects.equals(hCommentTime, that.hCommentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hCommentId, hCommentContent, hCommentScore, hCommentTime);
    }
}
