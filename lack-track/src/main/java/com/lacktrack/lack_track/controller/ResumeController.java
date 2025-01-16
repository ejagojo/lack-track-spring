package com.lacktrack.lack_track.controller;

import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.entity.Resume;
import com.lacktrack.lack_track.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.createResume(resume);
    }

    @GetMapping("/user/{userId}")
    public List<Resume> getResumeByUser(@PathVariable UUID userId) {
        User user = new User();
        user.setUserId(userId);
        return resumeService.getResumeByUser(user);
    }

    @GetMapping("/search")
    public List<Resume> searchResumes(@RequestParam String keyword) {
        return resumeService.searchResumes(keyword);
    }
}