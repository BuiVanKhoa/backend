package com.springmvc.final_project.ServiceImpl;

import java.util.List;

import com.springmvc.final_project.Entity.AdvertisersEntity;
import com.springmvc.final_project.Repository.AdvertisersRepository;
import com.springmvc.final_project.Service.AdvertisersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisersServiceImpl implements AdvertisersService {
    
    private AdvertisersRepository advertisersRepository;

    @Autowired
    public AdvertisersServiceImpl (AdvertisersRepository advertisersRepository) {
        this.advertisersRepository = advertisersRepository;
    }


	@Override
	public AdvertisersEntity createAdvertisers(AdvertisersEntity advertisersEntity) {
		return advertisersRepository.save(advertisersEntity);
	}

	@Override
	public List<AdvertisersEntity> getAllAdvertiserEntities() {
		return (List<AdvertisersEntity>) advertisersRepository.findAll(); 
	}

	@Override
	public AdvertisersEntity updateAdvertisers(AdvertisersEntity advertisersEntity) {
		return advertisersRepository.save(advertisersEntity);
	}

	@Override
	public void remove(AdvertisersEntity advertisersEntity) {
		advertisersRepository.delete(advertisersEntity);
		
	}

    
}