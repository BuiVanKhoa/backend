package com.springmvc.final_project.Repository;

import com.springmvc.final_project.Entity.CompaniesEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository <CompaniesEntity, Integer> {
    
}