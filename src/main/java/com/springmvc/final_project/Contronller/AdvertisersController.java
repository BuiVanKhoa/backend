package com.springmvc.final_project.Contronller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springmvc.final_project.Entity.AdvertisersEntity;
import com.springmvc.final_project.Model.AdvertiserFindByIdRequest;
import com.springmvc.final_project.Repository.AdvertisersRepository;
import com.springmvc.final_project.Service.AdvertisersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/advertiser")
public class AdvertisersController {
    
    
    private AdvertisersService advertisersService;

    @Autowired
    AdvertisersRepository advertisersRepository;

    @Autowired
    public AdvertisersController (AdvertisersService advertisersService) {
        this.advertisersService = advertisersService;
    }


    @PostMapping("/create")
    public ResponseEntity<AdvertisersEntity> createAdvertiser (@Valid @RequestBody AdvertisersEntity advertisersEntity){
            return new ResponseEntity<>(advertisersService.createAdvertisers(advertisersEntity), HttpStatus.OK);
    }
        
    @GetMapping("/show")
    public ResponseEntity<List<AdvertisersEntity>> showAdvertisersEntity() {
       
        List<AdvertisersEntity> advertisersEntities =advertisersService.getAllAdvertiserEntities();

        if (advertisersEntities.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(advertisersEntities, HttpStatus.OK);
         }

     @PutMapping ("/update")
     public ResponseEntity <AdvertisersEntity> updateAdvertiser ( @RequestBody AdvertisersEntity advertisersEntity){
        Optional <AdvertisersEntity> currentAdvertiser = advertisersRepository.findById(advertisersEntity.getId());
            if (!currentAdvertiser.isPresent()){
                return new ResponseEntity <> (HttpStatus.NO_CONTENT);
            }
                   
            currentAdvertiser.get().setId(advertisersEntity.getId());
            currentAdvertiser.get().setEmail (advertisersEntity.getEmail());
            currentAdvertiser.get().setStatus(advertisersEntity.getStatus());
            currentAdvertiser.get().setUserName(advertisersEntity.getUserName());
            
            advertisersService.updateAdvertisers(advertisersEntity);
                   return new ResponseEntity<>(currentAdvertiser.get(), HttpStatus.OK);
               }
    
     @DeleteMapping ("/delete")
    public ResponseEntity <AdvertisersEntity> deleteComapany (@RequestBody AdvertisersEntity advertisersEntity){
        Optional<AdvertisersEntity> currentAdvertiser = advertisersRepository.findById(advertisersEntity.getId());
            if(!currentAdvertiser.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                advertisersService.remove(currentAdvertiser.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/find")
    public ResponseEntity<AdvertisersEntity> findAdvertiserById( @RequestBody AdvertiserFindByIdRequest request) {
        Optional<AdvertisersEntity> advertiserEntity = advertisersRepository.findById(request.getId());

        if (!advertiserEntity.isPresent()) {
            return new ResponseEntity<>(advertiserEntity.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(advertiserEntity.get(), HttpStatus.OK);
    }
}