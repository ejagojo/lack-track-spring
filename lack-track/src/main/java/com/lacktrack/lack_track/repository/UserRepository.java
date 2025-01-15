package com.lacktrack.lack_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lacktrack.lack_track.entity.User;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email); // Query for finding users via email
}