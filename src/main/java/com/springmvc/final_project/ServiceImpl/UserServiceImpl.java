package com.springmvc.final_project.ServiceImpl;

import java.util.Optional;



import com.springmvc.final_project.Repository.UserRepository;
import com.springmvc.final_project.Service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // @Override
    // public User checkUserExists (String userName, String passWord){
    //     User user = this.userRepository.findByUserName(userName).size()>0 ? this.userRepository.findByUserName(userName).get(0):null;

    //     if(!user.equals(null)){
    //         if(user.getPassWord().equals(passWord)){
    //             return user;
    //         }
    //     }
    //     return null;
    // }

    // @Override
    // public User showEntityByPassWord(String passWord) {
    //     return this.userRepository.findByPassWord(passWord);
    // }

    

   
}

    

    

    

    

