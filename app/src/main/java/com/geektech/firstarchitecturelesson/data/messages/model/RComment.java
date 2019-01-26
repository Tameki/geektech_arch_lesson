package com.geektech.firstarchitecturelesson.data.messages.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by askar on 1/26/19
 * with Android Studio
 */
public class RComment extends RealmObject {
    private String comment;

    private Date createdAt;

    public RComment() {
    }

    public RComment(String comment) {
        this.comment = comment;
        this.createdAt = new Date();
    }

    public RComment(String comment, Date createdAt) {
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
