package com.discover.sample.service;

import com.discover.sample.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    void deleteUser(User user);
    Optional<User> getUser(Long id);
    List<User> getUsers();
}
