package com.springmvc.final_project.ServiceImpl;

import java.util.List;

import com.springmvc.final_project.Entity.CompaniesEntity;
import com.springmvc.final_project.Repository.CompaniesRepository;
import com.springmvc.final_project.Service.CompaniesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniesServiceImpl implements CompaniesService {

    private CompaniesRepository companiesRepository;

    @Autowired
    public CompaniesServiceImpl (CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public CompaniesEntity createCompanies(CompaniesEntity companiesEntity) {
        return companiesRepository.save(companiesEntity);
    }

    @Override
    public List<CompaniesEntity> getAllCompaniesEntities() {
        return (List<CompaniesEntity>) companiesRepository.findAll(); 
    }

    @Override
    public CompaniesEntity updateCompanies(CompaniesEntity companiesEntity) {
        return companiesRepository.save(companiesEntity);
    }

    @Override
    public void remove(CompaniesEntity companiesEntity) {
        companiesRepository.delete(companiesEntity);

    }
    
}