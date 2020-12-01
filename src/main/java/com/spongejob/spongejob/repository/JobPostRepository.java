package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findAll();

    void deleteByJobPostId(Long jobPostId);

    Optional<JobPost> findByJobPostId(Long jobPostId);
}