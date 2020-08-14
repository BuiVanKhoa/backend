package com.springmvc.final_project.Repository;

import com.springmvc.final_project.Entity.DacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DacRepository  extends JpaRepository <DacEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from account where id = :id")
    DacEntity findDacById (@Param("id") Integer id);
}

    

