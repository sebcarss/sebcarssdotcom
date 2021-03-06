package com.sebcarss.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "posts") // Adding annotation to select with MongoDB collection this maps to
public class Post {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String permalink;

    private String category;
    private String title;
    private Date datePosted;
    private String thumbnail;
    private String body;

    @Transient
    private String absoluteUrl;

    @Override
    public String toString() {
        return String.format("Post[id=%s, permalink=%s]", getId(), getPermalink());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAbsoluteUrl() {
        if (null == absoluteUrl) {
            StringBuffer sb = new StringBuffer();
            sb.append("/");
            sb.append(getPermalink());
            absoluteUrl = sb.toString();
        }

        return absoluteUrl;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
