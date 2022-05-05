package com.example.webdom6.repo.posts;

import com.example.webdom6.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepo implements IPostRepo{

    private static final List<Post> posts = new CopyOnWriteArrayList<>();

    public List<Post> all() {
        List<Post> postList = new ArrayList<>();
        posts.iterator().forEachRemaining(e -> {//todo ovo uradi na kraju
            postList.add(e);
        });
        return postList;
    }

    public void insert(Post post) {
        posts.add(post);
    }

    public Post find(int id) {
        return posts.get(id);
    }
}
