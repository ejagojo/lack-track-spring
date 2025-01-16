package com.lacktrack.lack_track.service;

import com.lacktrack.lack_track.entity.Application;
import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplicationsByUser(User user) {
        return applicationRepository.findByUser(user);
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }

    public void deleteApplication(UUID appId) {
        applicationRepository.deleteById(appId);
    }
}
