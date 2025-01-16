package com.lacktrack.lack_track.service;

import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by their ID
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    // Retrieve a user by their email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Create a new user
    public User createUser(User user) {
        // Additional validation can be added here if needed
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(UUID userId, User updatedUser) {
        User existingUser = getUserById(userId);

        // Validate incoming data (e.g., non-null fields)
        if (updatedUser.getName() == null || updatedUser.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (updatedUser.getEmail() == null || updatedUser.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        // Update modifiable fields
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        // Save the updated user
        return userRepository.save(existingUser);
    }

    // Delete a user by their ID
    public void deleteUser(UUID userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }
}
