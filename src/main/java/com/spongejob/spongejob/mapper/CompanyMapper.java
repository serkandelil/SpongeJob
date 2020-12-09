package com.spongejob.spongejob.mapper;

import com.spongejob.spongejob.dto.CompanyDTO;
import com.spongejob.spongejob.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

    public CompanyDTO maptoDto(Company company) {
        if (company == null) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setCompanyId(company.getCompanyId());
        companyDTO.setName(company.getName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setPhone(company.getPhone());
        companyDTO.setEmail(company.getEmail());


        return companyDTO;
    }

    public List<CompanyDTO> maptoDto(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyDTO> list = new ArrayList<>();
        for ( Company company : companies ) {
            list.add( maptoDto( company ) );
        }

        return list;
    }

    public Company maptoEntity(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            return null;
        }

        Company company = new Company();

        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        company.setPhone(companyDTO.getPhone());
        company.setEmail(companyDTO.getEmail());
        company.setUsername(companyDTO.getUsername());
        company.setPassword(companyDTO.getPassword());

        return company;
    }

    public List<Company> maptoEntity(List<CompanyDTO> companyDTOS) {
        if ( companyDTOS == null ) {
            return null;
        }

        List<Company> list = new ArrayList<>();
        for ( CompanyDTO companyDTO : companyDTOS ) {
            list.add( maptoEntity( companyDTO ) );
        }

        return list;
    }

}