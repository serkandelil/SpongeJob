package com.spongejob.spongejob.controller;

import com.spongejob.spongejob.dto.*;
import com.spongejob.spongejob.mapper.ApplicationMapper;
import com.spongejob.spongejob.mapper.CompanyMapper;
import com.spongejob.spongejob.mapper.EmployeeMapper;
import com.spongejob.spongejob.mapper.JobPostMapper;
import com.spongejob.spongejob.model.Application;
import com.spongejob.spongejob.model.Company;
import com.spongejob.spongejob.model.Employee;
import com.spongejob.spongejob.model.JobPost;
import com.spongejob.spongejob.service.ApplicationService;
import com.spongejob.spongejob.service.CompanyService;
import com.spongejob.spongejob.service.EmployeeService;
import com.spongejob.spongejob.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final JobPostService jobPostService;
    private final JobPostMapper jobPostMapper;
    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;
    LocalDate now = LocalDate.now();

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmployeeId(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        EmployeeDTO employeeDTO = employeeMapper.maptoDto(employee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity<Long> login(@PathVariable String username, @PathVariable String password) {
        Employee employee = employeeService.getEmployeeByUsernameAndPassword(username, password);
        Long employeeId = employee.getEmployeeId();
        return new ResponseEntity<>(employeeId, HttpStatus.OK);
    }

    @GetMapping("/jobPost/{type}")
    public ResponseEntity<List<JobPostDTO>> getJobPostsByType(@PathVariable String type) {
        List<JobPost> jobPosts = jobPostService.getJobPostsByType(type);
        List<JobPostDTO> jobPostDTOS = jobPostMapper.maptoDto(jobPosts);
        return new ResponseEntity<>(jobPostDTOS, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}/applications")
    public ResponseEntity<List<ApplicationWithJPInfoDTO>> getApplicationsByEmployeeId(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        List<Application> applications = employee.getApplications();
        List<ApplicationWithJPInfoDTO> applicationWithJPInfoDTOS = applicationMapper.maptoJPInfoDto(applications);
        return new ResponseEntity<>(applicationWithJPInfoDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.maptoEntity(employeeDTO);
        Employee addedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeMapper.maptoDto(addedEmployee), HttpStatus.OK);
    }

    @PostMapping("/{employeeId}/jobPost/{jobPostId}")
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody ApplicationDTO applicationDTO, @PathVariable Long employeeId, @PathVariable Long jobPostId) {
        Application application = applicationMapper.maptoEntity(applicationDTO);
        JobPost jobPost = jobPostService.getJobPostByJobPostId(jobPostId);
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        application.setApplicant(employee);
        application.setJobPost(jobPost);
        application.setApplicationDate(now);
        jobPost.setApplicantCount(jobPost.getApplicantCount() + 1);
        Application addedApplication = applicationService.addApplication(application);
        return new ResponseEntity<>(applicationMapper.maptoDto(addedApplication), HttpStatus.OK);
    }

}