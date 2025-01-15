package com.lacktrack.lack_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lacktrack.lack_track.entity.Resume;
import com.lacktrack.lack_track.entity.User;
import java.util.List;
import java.util.UUID;

public interface ResumeRepository extends JpaRepository<Resume, UUID> {
    List<Resume> findByUser(User user); // Retrieves all resumes uploaded by a specific user

    List<Resume> findByParsedDataContaining(String Keyword); // Enables for search for resumes where the parsed data json contains specific words
}