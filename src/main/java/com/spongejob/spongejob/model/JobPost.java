package com.spongejob.spongejob.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue
    @Column(name = "JOBPOST_ID")
    private Long jobPostId;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "EXPECTATION")
    private String expectation;

    @Column(name = "APPLICANT_COUNT")
    private int applicantCount;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "EVALUATION_DATE")
    private LocalDate evaluationDate;

    @OneToMany(mappedBy = "jobPost",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Application> applications;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="COMPANY_ID", nullable = false)
    private Company company;
}