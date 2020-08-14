package com.springmvc.final_project.Repository;

import com.springmvc.final_project.Entity.AdvertisersEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisersRepository extends JpaRepository<AdvertisersEntity, Integer> {
    
}