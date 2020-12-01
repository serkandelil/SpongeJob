package com.spongejob.spongejob.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue
    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "APPLICATION_DATE")
    private LocalDate applicationDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="EMPLOYEE_ID", nullable = false)
    private Employee applicant;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="JOBPOST_ID", nullable = false)
    private JobPost jobPost;

}