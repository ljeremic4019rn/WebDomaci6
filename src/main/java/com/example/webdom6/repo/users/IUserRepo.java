package com.example.webdom6.repo.users;

import com.example.webdom6.models.User;

public interface IUserRepo {
    public User find(String username);

}
