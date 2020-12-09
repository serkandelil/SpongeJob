package com.spongejob.spongejob.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class EmployeeDTO {

    private Long employeeId;

    private String firstname;

    private String surname;

    private String phone;

    private String email;

    private String username;

    private String password;

    private int age;

    private String cv;

    @JsonCreator
    public EmployeeDTO(@JsonProperty("employeeId") Long employeeId,
                       @JsonProperty("firstname") String firstname,
                       @JsonProperty("surname") String surname,
                       @JsonProperty("phone") String phone,
                       @JsonProperty("email") String email,
                       @JsonProperty("username") String username,
                       @JsonProperty("password") String password,
                       @JsonProperty("age") int age,
                       @JsonProperty("cv") String cv) {
        this.employeeId = employeeId;
        this.firstname = firstname;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.cv = cv;
    }
}