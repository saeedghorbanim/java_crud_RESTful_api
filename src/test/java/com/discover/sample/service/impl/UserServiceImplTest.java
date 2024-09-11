package com.discover.sample.service.impl;

import com.discover.sample.model.User;
import com.discover.sample.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        User returnUser = new User();
        returnUser.setId(12L);
        returnUser.setFirstName("Saeed");
        returnUser.setLastName("Ghorbani");
        returnUser.setAge(25);
        when(this.userRepo.save(any(User.class))).thenReturn(returnUser);

        User user = new User();
        user.setFirstName("Saeed");
        user.setLastName("Ghorbani");
        user.setAge(25);
        user = this.userService.createUser(user);

        assertEquals(12, user.getId());
    }


    @Test
    void getUser() {
        Long id = 2L;
        User returnUser = new User();
        returnUser.setFirstName("Ali");
        returnUser.setLastName(("Ghorbani"));
        returnUser.setId(id);

        when(this.userRepo.findById(eq(id))).
                thenReturn(Optional.of(returnUser));

        Optional<User> optUser = this.userService.getUser(1L);
        assertTrue(optUser.isEmpty());

        optUser = this.userService.getUser(2L);
        assertTrue(optUser.isPresent());
        assertEquals(2, optUser.get().getId());
    }

}