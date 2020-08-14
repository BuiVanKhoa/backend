package com.springmvc.final_project.Entity;

import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.springmvc.final_project.Audit.Auditable;
import org.springframework.data.annotation.LastModifiedDate;
import com.springmvc.final_project.Entity.AdvertisersEntity;



@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "dacs")


public class DacEntity extends Auditable <String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    @Column
    private String status;

    @Column
    private String userName;

    
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dac")
     private List<AdvertisersEntity> advertiserList ;


    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    protected Date lastModifiedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<AdvertisersEntity> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<AdvertisersEntity> advertiserList) {
        this.advertiserList = advertiserList;
    }
    
}