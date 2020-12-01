package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findAll();

}