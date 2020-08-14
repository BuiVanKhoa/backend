package com.springmvc.final_project.ServiceImpl;

import java.util.List;
import java.util.Optional;

import com.springmvc.final_project.Entity.DacEntity;
import com.springmvc.final_project.Repository.DacRepository;
import com.springmvc.final_project.Service.DacService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DacServiceImpl implements DacService {

    private DacRepository dacRepository;

    @Autowired
    public DacServiceImpl(DacRepository dacRepository) {
        this.dacRepository = dacRepository;
    }

    @Override
    public DacEntity createDac(DacEntity dacEntity) {
        return dacRepository.save(dacEntity);
    }

    @Override
    public List<DacEntity> getAllDacEntities() {
        return (List<DacEntity>) dacRepository.findAll(); 
    }

    @Override
    public DacEntity updateDac (DacEntity dacEntity) {

        return dacRepository.save(dacEntity);
    }

    @Override
    public void remove (DacEntity dacEntity) {
        dacRepository.delete(dacEntity);
    }
}