package com.geektech.firstarchitecturelesson.data.messages.local.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by askar on 1/22/19
 * with Android Studio
 */
public class RMessage extends RealmObject {

    @PrimaryKey
    private long id;

    private String contentType;

    private String content;

    private Date createdAt;

    public RMessage() {
        this.id = 0;
        this.contentType = "";
        this.content = "";
        this.createdAt = new Date();
    }

    public RMessage(long id, String contentType, String content, Date createdAt) {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return id + " " + contentType + " " + content;
    }
}
