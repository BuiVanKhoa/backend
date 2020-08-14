package com.springmvc.final_project.Service;

import java.util.List;

import com.springmvc.final_project.Entity.CompaniesEntity;

import org.springframework.stereotype.Service;


@Service
public interface CompaniesService {

    CompaniesEntity createCompanies ( CompaniesEntity companiesEntity);
    List<CompaniesEntity> getAllCompaniesEntities(); 
    CompaniesEntity updateCompanies (CompaniesEntity companiesEntity);
    void remove (CompaniesEntity dacEntity);

}