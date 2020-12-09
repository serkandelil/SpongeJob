package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAll();

    Optional<Company> findByCompanyId(Long jobPostId);

    Optional<Company> findByUsernameAndPassword(String username, String password );

    void deleteByCompanyId(Long companyId);
}