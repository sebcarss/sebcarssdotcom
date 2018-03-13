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

    private String title;
    private Date datePosted;
    private String thumbnail;
    private String body;
    private String synopsis;

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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
