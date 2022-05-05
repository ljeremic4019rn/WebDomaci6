package com.example.webdom6.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Post {

    private int id;
    private User author;
    private String title;
    private String content;
    private LocalDate dateCreated;
    private final List<Comment> comments = new CopyOnWriteArrayList<>();

    public Post(int id, User author, String title, String content, LocalDate dateCreated) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;

        comments.add(new Comment("user1", "omg best article ever"));
        comments.add(new Comment("user2", "yaaaaas queeeen soooo goouudd"));
    }

    public String shortenedText(){
        return String.format("%."+ content.length()/4 +"s", content);
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
