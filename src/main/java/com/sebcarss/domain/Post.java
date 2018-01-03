package com.sebcarss.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts") // Adding annotation to select with MongoDB collection this maps to
public class Post {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String permalink;

    private String category;
    private String title;
    private int year;
    private int month;
    private int day;

    // Generated Fields
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
            sb.append(getCategory());
            sb.append("/");
            sb.append(getPermalink());
            absoluteUrl = sb.toString();
        }

        return absoluteUrl;
    }
}
