package com.example.webdom6.models;

public class Comment {

    private User author;
    private String content;

    public Comment(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
