package com.spongejob.spongejob.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AGE")
    private int age;

    @Column(name = "CV")
    private String cv;

    @OneToMany(mappedBy = "applicant",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Application> applications;
}