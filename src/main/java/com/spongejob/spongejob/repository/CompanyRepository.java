package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAll();

}