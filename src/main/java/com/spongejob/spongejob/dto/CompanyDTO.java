package com.spongejob.spongejob.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CompanyDTO {

    private Long companyId;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String username;

    private String password;

    @JsonCreator
    public CompanyDTO(@JsonProperty("companyId") Long companyId,
                      @JsonProperty("name") String name,
                      @JsonProperty("address") String address,
                      @JsonProperty("phone") String phone,
                      @JsonProperty("email") String email,
                      @JsonProperty("username") String username,
                      @JsonProperty("password") String password) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}