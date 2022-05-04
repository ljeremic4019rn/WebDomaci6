package com.example.webdom6.repo.posts;

import com.example.webdom6.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepo implements IPostRepo{

    private static final List<Post> quotes = new CopyOnWriteArrayList<>();

    public List<Post> all() {
        List<Post> quoteList = new ArrayList<>();
        quotes.iterator().forEachRemaining(e -> {//todo ovo uradi na kraju
            quoteList.add(e);
        });
        return quoteList;
    }

    public void insert(Post quote) {
        quotes.add(quote);
    }
}
