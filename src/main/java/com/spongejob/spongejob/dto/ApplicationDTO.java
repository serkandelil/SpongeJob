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
public class ApplicationDTO {

    private Long applicationId;

    private String answer;

    private LocalDate applicationDate;

    @JsonCreator
    public ApplicationDTO(@JsonProperty("applicationId") Long applicationId,
                          @JsonProperty("answer") String answer,
                          @JsonProperty("applicationDate") LocalDate applicationDate) {
        this.applicationId = applicationId;
        this.answer = answer;
        this.applicationDate = applicationDate;
    }
}