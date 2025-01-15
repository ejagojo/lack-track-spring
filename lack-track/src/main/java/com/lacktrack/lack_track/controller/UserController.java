package com.lacktrack.lack_track.controller;

import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable UUID userId, @RequestBody User user) {
        return userService.updateUser(userId, user)
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@Pathvariable UUID userId) {
        userService.deleteUser(userId);
    }
}