package com.springmvc.final_project.Repository;

import com.springmvc.final_project.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AdminEntity,Integer> {
    AdminEntity findByUserName(String userName);
    AdminEntity findByPassWord(String passWord);
    
    @Query(nativeQuery = true, value = "select * from user where userName = :username")
    AdminEntity getUserByUsername(@Param("username") String userName);
}