package com.lacktrack.lack_track.controller;

import com.lacktrack.lack_track.entity.Application;
import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.createApplication(application);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable UUID userId) {
        User user = new User();
        user.setUserId(userId);
        return applicationService.getApplicationsByUser(user);
    }

    @GetMapping("/status/{status}")
    public List<Application> getApplicationsByStatus(@PathVariable String status) {
        return applicationService.getApplicationsByStatus(status);
    }

    @DeleteMapping("/{appId}")
    public void deleteApplication(@PathVariable UUID appId) {
        applicationService.deleteApplication(appId);
    }
}
