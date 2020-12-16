package com.spongejob.spongejob.controller;

import com.spongejob.spongejob.dto.ApplicationWithEmpInfoDTO;
import com.spongejob.spongejob.dto.CompanyDTO;
import com.spongejob.spongejob.dto.JobPostDTO;
import com.spongejob.spongejob.mapper.ApplicationMapper;
import com.spongejob.spongejob.mapper.CompanyMapper;
import com.spongejob.spongejob.mapper.JobPostMapper;
import com.spongejob.spongejob.model.Application;
import com.spongejob.spongejob.model.Company;
import com.spongejob.spongejob.model.JobPost;
import com.spongejob.spongejob.service.CompanyService;
import com.spongejob.spongejob.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;
    private final JobPostService jobPostService;
    private final JobPostMapper jobPostMapper;
    private final ApplicationMapper applicationMapper;

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDTO> getCompanyByCompanyId(@PathVariable Long companyId) {
        Company company = companyService.getCompanyByCompanyId(companyId);
        CompanyDTO companyDTO = companyMapper.maptoDto(company);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity<Long> login(@PathVariable String username, @PathVariable String password) {
        Company company = companyService.getCompanyByUsernameAndPassword(username, password);
        Long companyId = company.getCompanyId();
        return new ResponseEntity<>(companyId, HttpStatus.OK);
    }

    @GetMapping("/jobPost/{jobPostId}/applications")
    public ResponseEntity<List<ApplicationWithEmpInfoDTO>> getApplicantions(@PathVariable Long jobPostId) {
        JobPost jobPost = jobPostService.getJobPostByJobPostId(jobPostId);
        List<Application> applications = jobPost.getApplications();
        List<ApplicationWithEmpInfoDTO> applicationWithEmpInfoDTOS = applicationMapper.maptoEmpInfoDto(applications);
        return new ResponseEntity<>(applicationWithEmpInfoDTOS, HttpStatus.OK);
    }

    @GetMapping("/{companyId}/jobPosts")
    public ResponseEntity<List<JobPostDTO>> getJobPosts(@PathVariable Long companyId) {
        Company company = companyService.getCompanyByCompanyId(companyId);
        List<JobPost> jobPosts = jobPostService.getJobPostByCompany(company);
        List<JobPostDTO> jobPostDTOS = jobPostMapper.maptoDto(jobPosts);
        return new ResponseEntity<>(jobPostDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = companyMapper.maptoEntity(companyDTO);
        Company addedCompany = companyService.addCompany(company);
        return new ResponseEntity<>(companyMapper.maptoDto(addedCompany), HttpStatus.OK);
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<JobPostDTO> addJobPost(@RequestBody JobPostDTO jobPostDTO, @PathVariable Long companyId) {
        JobPost jobPost = jobPostMapper.maptoEntity(jobPostDTO);
        Company company = companyService.getCompanyByCompanyId(companyId);
        jobPost.setCompany(company);
        JobPost addedJobPost = jobPostService.addJobPost(jobPost);
        return new ResponseEntity<>(jobPostMapper.maptoDto(addedJobPost), HttpStatus.OK);
    }

}