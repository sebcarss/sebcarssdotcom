package com.sebcarss.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts") // Adding annotation to select with MongoDB collection this maps to
public class Post {

    @Id
    private long id;
    private String title;

    @Override
    public String toString() {
        return String.format("Post[id=%s, title=%s]", id, title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
