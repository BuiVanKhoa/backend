package com.springmvc.final_project.Contronller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springmvc.final_project.Entity.CompaniesEntity;
import com.springmvc.final_project.Model.CompaniesFindByIdRequest;
import com.springmvc.final_project.Repository.CompaniesRepository;
import com.springmvc.final_project.Service.CompaniesService;

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
@RequestMapping("/company")

public class CompaniesController {
    
    private CompaniesService companiesService;

    @Autowired
    CompaniesRepository companiesRepository;

    @Autowired
    public CompaniesController(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }


    @PostMapping("/create")
    public ResponseEntity<CompaniesEntity> createCompanies (@Valid @RequestBody CompaniesEntity companiesEntity){
            return new ResponseEntity<>(companiesService.createCompanies(companiesEntity), HttpStatus.OK);
    }
        
    @GetMapping("/show")
    public ResponseEntity<List<CompaniesEntity>> showCompanies() {
       
        List<CompaniesEntity> companiesEntities = companiesService.getAllCompaniesEntities();

        if (companiesEntities.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companiesEntities, HttpStatus.OK);
         }

     @PutMapping ("/update")
     public ResponseEntity <CompaniesEntity> updateCompanies ( @RequestBody CompaniesEntity companiesEntity){
        Optional <CompaniesEntity> currentCompany = companiesRepository.findById(companiesEntity.getId());
            if (!currentCompany.isPresent()){
                return new ResponseEntity <> (HttpStatus.NO_CONTENT);
            }
                   
                currentCompany.get().setId(companiesEntity.getId());
                currentCompany.get().setName(companiesEntity.getName());
            
                   companiesService.updateCompanies(companiesEntity);
                   return new ResponseEntity<>(currentCompany.get(), HttpStatus.OK);
               }
    
     @DeleteMapping ("/delete")
    public ResponseEntity <CompaniesEntity> deleteComapany (@RequestBody CompaniesEntity companiesEntity){
        Optional<CompaniesEntity> currentCompany = companiesRepository.findById(companiesEntity.getId());
            if(!currentCompany.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                 companiesService.remove(currentCompany.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/find")
    public ResponseEntity<CompaniesEntity> findCompanyById( @RequestBody CompaniesFindByIdRequest request) {
        Optional<CompaniesEntity> companyEntity = companiesRepository.findById(request.getId());

        if (!companyEntity.isPresent()) {
            return new ResponseEntity<>(companyEntity.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companyEntity.get(), HttpStatus.OK);
    }
}