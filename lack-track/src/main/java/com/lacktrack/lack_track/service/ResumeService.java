package com.lacktrack.lack_track.service;

import com.lacktrack.lack_track.entity.Resume;
import com.lacktrack.lack_track.entity.User;
import com.lacktrack.lack_track.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepositroy) {
        this.resumeRepository = resumeRepositroy;
    }

    public List<Resume> getResumeByUser(User user) {
        return resumeRepository.findByUser(user);
    }

    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public List<Resume> searchResumes(String keyword) {
        return resumeRepository.findByParsedDataContaining(keyword);
    }
}