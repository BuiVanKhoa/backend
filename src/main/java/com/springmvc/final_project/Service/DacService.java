package com.springmvc.final_project.Service;

import java.util.List;

import com.springmvc.final_project.Entity.DacEntity;

import org.springframework.stereotype.Service;

@Service
public interface DacService {

    DacEntity createDac ( DacEntity dacEntity);
    List<DacEntity> getAllDacEntities(); 
    DacEntity updateDac (DacEntity dacEntity);
    void remove (DacEntity dacEntity);
    
    
}