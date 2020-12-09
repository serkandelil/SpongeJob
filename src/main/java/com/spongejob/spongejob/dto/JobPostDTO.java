package com.spongejob.spongejob.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class JobPostDTO {

    private Long jobPostId;

    private String jobName;

    private String companyName;

    private String type;

    private int salary;

    private String address;

    private String position;

    private String expectation;

    private int applicantCount;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate evaluationDate;

    @JsonCreator
    public JobPostDTO(@JsonProperty("jobPostId") Long jobPostId,
                      @JsonProperty("jobName") String jobName,
                      @JsonProperty("companyName") String companyName,
                      @JsonProperty("type") String type,
                      @JsonProperty("salary") int salary,
                      @JsonProperty("address") String address,
                      @JsonProperty("position") String position,
                      @JsonProperty("expectation") String expectation,
                      @JsonProperty("applicantCount") int applicantCount,
                      @JsonProperty("startDate") LocalDate startDate,
                      @JsonProperty("endDate") LocalDate endDate,
                      @JsonProperty("evaluationDate") LocalDate evaluationDate) {
        this.jobPostId = jobPostId;
        this.jobName = jobName;
        this.companyName = companyName;
        this.type = type;
        this.salary = salary;
        this.address = address;
        this.position = position;
        this.expectation = expectation;
        this.applicantCount = applicantCount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.evaluationDate = evaluationDate;
    }
}