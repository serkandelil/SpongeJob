package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findAll();

    Optional<Application> findByApplicationId(Long jobPostId);

    void deleteByApplicationId(Long companyId);
}