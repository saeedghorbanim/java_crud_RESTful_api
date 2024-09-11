package com.discover.sample.api;

import com.discover.sample.model.User;
import com.discover.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Optional<User> getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = this.userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
