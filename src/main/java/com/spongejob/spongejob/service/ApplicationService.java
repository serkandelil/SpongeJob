package com.spongejob.spongejob.service;

import com.spongejob.spongejob.model.Application;
import com.spongejob.spongejob.model.Company;
import com.spongejob.spongejob.repository.ApplicationRepository;
import com.spongejob.spongejob.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getJobPostByJobPostId(Long jobPostId) {
        return applicationRepository.findByApplicationId(jobPostId).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteApplication(Long companyId) {
        applicationRepository.deleteByApplicationId(companyId);
    }
}