package com.example.webdom6.repo.posts;

import com.example.webdom6.models.Post;

import java.util.List;

public interface IPostRepo {
    public List<Post> all();

    public void insert(Post quote);

    public Post find(int id);
}
