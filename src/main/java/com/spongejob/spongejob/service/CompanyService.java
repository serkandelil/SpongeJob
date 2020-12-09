package com.spongejob.spongejob.service;

import com.spongejob.spongejob.model.Company;
import com.spongejob.spongejob.model.JobPost;
import com.spongejob.spongejob.repository.CompanyRepository;
import com.spongejob.spongejob.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyByCompanyId(Long jobPostId) {
        return companyRepository.findByCompanyId(jobPostId).orElseThrow(EntityNotFoundException::new);
    }

    public Company getCompanyByUsernameAndPassword(String username, String password) {
        return companyRepository.findByUsernameAndPassword(username,password).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteByCompanyId(companyId);
    }
}