package com.discover.sample.service.impl;

import com.discover.sample.model.User;
import com.discover.sample.repository.UserRepository;
import com.discover.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
       return this.userRepo.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepo.delete(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.userRepo.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return this.userRepo.findAll();
    }
}
