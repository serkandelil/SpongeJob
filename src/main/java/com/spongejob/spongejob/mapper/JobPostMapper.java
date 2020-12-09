package com.spongejob.spongejob.mapper;

import com.spongejob.spongejob.dto.JobPostDTO;
import com.spongejob.spongejob.model.JobPost;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobPostMapper {

    public JobPostDTO maptoDto(JobPost jobPost) {
        if (jobPost == null) {
            return null;
        }

        JobPostDTO jobPostDTO = new JobPostDTO();

        jobPostDTO.setJobPostId(jobPost.getJobPostId());
        jobPostDTO.setJobName(jobPost.getJobName());
        jobPostDTO.setCompanyName(jobPost.getCompany().getName());
        jobPostDTO.setType(jobPost.getType());
        jobPostDTO.setSalary(jobPost.getSalary());
        jobPostDTO.setAddress(jobPost.getAddress());
        jobPostDTO.setPosition(jobPost.getPosition());
        jobPostDTO.setExpectation(jobPost.getExpectation());
        jobPostDTO.setApplicantCount(jobPost.getApplicantCount());
        jobPostDTO.setStartDate(jobPost.getStartDate());
        jobPostDTO.setEndDate(jobPost.getEndDate());
        jobPostDTO.setEvaluationDate(jobPost.getEvaluationDate());

        return jobPostDTO;
    }

    public List<JobPostDTO> maptoDto(List<JobPost> jobPosts) {
        if ( jobPosts == null ) {
            return null;
        }

        List<JobPostDTO> list = new ArrayList<>();
        for ( JobPost jobPost : jobPosts ) {
            list.add( maptoDto( jobPost ) );
        }

        return list;
    }

    public JobPost maptoEntity(JobPostDTO jobPostDTO) {
        if (jobPostDTO == null) {
            return null;
        }

        JobPost jobPost = new JobPost();


        jobPost.setJobName(jobPostDTO.getJobName());
        jobPost.setType(jobPostDTO.getType());
        jobPost.setSalary(jobPostDTO.getSalary());
        jobPost.setAddress(jobPostDTO.getAddress());
        jobPost.setPosition(jobPostDTO.getPosition());
        jobPost.setExpectation(jobPostDTO.getExpectation());
        jobPost.setApplicantCount(jobPostDTO.getApplicantCount());
        jobPost.setStartDate(jobPostDTO.getStartDate());
        jobPost.setEndDate(jobPostDTO.getEndDate());
        jobPost.setEvaluationDate(jobPostDTO.getEvaluationDate());


        return jobPost;
    }

    public List<JobPost> maptoEntity(List<JobPostDTO> jobPostDTOS) {
        if ( jobPostDTOS == null ) {
            return null;
        }

        List<JobPost> list = new ArrayList<>();
        for ( JobPostDTO jobPostDTO : jobPostDTOS ) {
            list.add( maptoEntity( jobPostDTO ) );
        }

        return list;
    }
}