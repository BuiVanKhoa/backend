package com.springmvc.final_project.Contronller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springmvc.final_project.Entity.DacEntity;
import com.springmvc.final_project.Model.DacFindByIdRequest;
import com.springmvc.final_project.Repository.DacRepository;
import com.springmvc.final_project.Service.DacService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dac")
public class DacController {

    private DacService dacService;

    @Autowired
    DacRepository dacRepository;

    @Autowired
    public DacController(DacService dacService) {
        this.dacService = dacService;
    }


    @PostMapping("/create")
    public ResponseEntity<DacEntity> createDac (@Valid @RequestBody DacEntity dacEntity){
            return new ResponseEntity<>(dacService.createDac(dacEntity), HttpStatus.OK);
    }
        
    @GetMapping("/show")
    public ResponseEntity<List<DacEntity>> showDacAccount() {
       
        List<DacEntity> dacEntities = dacService.getAllDacEntities();

        if (dacEntities.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dacEntities, HttpStatus.OK);
         }

     @RequestMapping (value = "/update", method = RequestMethod.PUT)
     public ResponseEntity <DacEntity> updateDacAccount ( @RequestBody DacEntity dacEntity){
        Optional <DacEntity> currentDacAccount = dacRepository.findById(dacEntity.getId());
            if (!currentDacAccount.isPresent()){
                return new ResponseEntity <> (HttpStatus.NO_CONTENT);
            }
                   
                currentDacAccount.get().setEmail(dacEntity.getEmail());
                currentDacAccount.get().setStatus(dacEntity.getStatus());
            
                   dacService.updateDac(dacEntity);
                   return new ResponseEntity<>(currentDacAccount.get(), HttpStatus.OK);
               }
    
     @RequestMapping (value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity <DacEntity> deleteDacAccount (@RequestBody DacEntity dacEntity){
        Optional<DacEntity> currentDacAccount = dacRepository.findById(dacEntity.getId());
            if(!currentDacAccount.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                 dacService.remove(currentDacAccount.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<DacEntity> findDacById( @RequestBody DacFindByIdRequest request) {
        Optional<DacEntity> dacEntity = dacRepository.findById(request.getId());

        if (!dacEntity.isPresent()) {
            return new ResponseEntity<>(dacEntity.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dacEntity.get(), HttpStatus.OK);
    }
}