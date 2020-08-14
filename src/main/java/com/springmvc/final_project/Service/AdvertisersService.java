package com.springmvc.final_project.Service;

import java.util.List;

import com.springmvc.final_project.Entity.AdvertisersEntity;

import org.springframework.stereotype.Service;

@Service
public interface AdvertisersService {

    AdvertisersEntity createAdvertisers ( AdvertisersEntity advertisersEntity);
    List<AdvertisersEntity> getAllAdvertiserEntities(); 
    AdvertisersEntity updateAdvertisers (AdvertisersEntity advertisersEntity);
    void remove (AdvertisersEntity advertisersEntity);
}