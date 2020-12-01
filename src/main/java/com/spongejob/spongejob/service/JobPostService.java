package com.spongejob.spongejob.service;

import com.spongejob.spongejob.model.Employee;
import com.spongejob.spongejob.model.JobPost;
import com.spongejob.spongejob.repository.EmployeeRepository;
import com.spongejob.spongejob.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public JobPost addEmployee(JobPost employee) {
        return jobPostRepository.save(employee);
    }

    public List<JobPost> getAllEmployees() {
        return jobPostRepository.findAll();
    }

    public JobPost getJobPostByJobPostId(Long jobPostId) {
        return jobPostRepository.findByJobPostId(jobPostId).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteJobPost(Long jobPostId) {
        jobPostRepository.deleteByJobPostId(jobPostId);
    }
}