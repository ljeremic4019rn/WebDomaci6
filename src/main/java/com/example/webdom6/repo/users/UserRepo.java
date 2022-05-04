package com.example.webdom6.repo.users;

import com.example.webdom6.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepo implements IUserRepo{

    private static final Map<String, User> users = new ConcurrentHashMap<>();

    static {
        users.put("luka", new User("luka", DigestUtils.sha256Hex("1234")));
        users.put("marko", new User("marko", DigestUtils.sha256Hex("1234")));
    }

    public User find(String username) {
        return users.get(username);
    }
}
