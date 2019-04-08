package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Essaycomment {
    private int eCommentId;
    private String eCommentContent;
    private int eCommentScore;
    private Timestamp eCommentTime;

    @Id
    @Column(name = "ECommentID")
    public int geteCommentId() {
        return eCommentId;
    }

    public void seteCommentId(int eCommentId) {
        this.eCommentId = eCommentId;
    }

    @Basic
    @Column(name = "ECommentContent")
    public String geteCommentContent() {
        return eCommentContent;
    }

    public void seteCommentContent(String eCommentContent) {
        this.eCommentContent = eCommentContent;
    }

    @Basic
    @Column(name = "ECommentScore")
    public int geteCommentScore() {
        return eCommentScore;
    }

    public void seteCommentScore(int eCommentScore) {
        this.eCommentScore = eCommentScore;
    }

    @Basic
    @Column(name = "ECommentTime")
    public Timestamp geteCommentTime() {
        return eCommentTime;
    }

    public void seteCommentTime(Timestamp eCommentTime) {
        this.eCommentTime = eCommentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Essaycomment that = (Essaycomment) o;
        return eCommentId == that.eCommentId &&
                eCommentScore == that.eCommentScore &&
                Objects.equals(eCommentContent, that.eCommentContent) &&
                Objects.equals(eCommentTime, that.eCommentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eCommentId, eCommentContent, eCommentScore, eCommentTime);
    }
}
