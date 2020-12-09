package com.spongejob.spongejob.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spongejob.spongejob.model.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
public class ApplicationWithEmpInfoDTO {

    private String answer;

    private LocalDate applicationDate;

    private String firstname;

    private String surname;

    private String phone;

    private String email;

    private int age;

    private String cv;

    @JsonCreator
    public ApplicationWithEmpInfoDTO(@JsonProperty("answer") String answer,
                                     @JsonProperty("applicationDate") LocalDate applicationDate,
                                     @JsonProperty("firstname") String firstname,
                                     @JsonProperty("surname") String surname,
                                     @JsonProperty("phone") String phone,
                                     @JsonProperty("email") String email,
                                     @JsonProperty("age") int age,
                                     @JsonProperty("cv") String cv
    ) {
        this.answer = answer;
        this.applicationDate = applicationDate;
        this.firstname = firstname;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.cv = cv;
    }
}