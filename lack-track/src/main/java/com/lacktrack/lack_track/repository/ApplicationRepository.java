package com.lacktrack.lack_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lacktrack.lack_track.entity.Application;
import com.lacktrack.lack_track.entity.User;
import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByUser(User user); // Retrieves all applications for a specific User

    List<Application> findByStatus(String status); // Would allow for filtering and would search for statuses e.g "In Progress", "Submitted"

    List<Application> findByCompanyName(String companyName); // Retrieves all application for a specific company
}