package com.qdu.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Message {
    private int messageId;
    private String messageContent;
    private int messageScore;
    private Timestamp messageTime;

    @Id
    @Column(name = "MessageID")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "MessageContent")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "MessageScore")
    public int getMessageScore() {
        return messageScore;
    }

    public void setMessageScore(int messageScore) {
        this.messageScore = messageScore;
    }

    @Basic
    @Column(name = "MessageTime")
    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId &&
                messageScore == message.messageScore &&
                Objects.equals(messageContent, message.messageContent) &&
                Objects.equals(messageTime, message.messageTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageContent, messageScore, messageTime);
    }
}
