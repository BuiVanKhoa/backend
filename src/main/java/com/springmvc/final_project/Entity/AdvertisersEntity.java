package com.springmvc.final_project.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.springmvc.final_project.Audit.Auditable;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "advertisers")
public class AdvertisersEntity extends Auditable <String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    @Column
    private String status;

    @Column
    private String userName;


    @ManyToOne 
    @JoinColumn(name = "company_id")
    private CompaniesEntity company;

    
    @ManyToOne
    @JoinColumn (name = "dac_username")
    private DacEntity dac;

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

    public CompaniesEntity getCompany() {
        return company;
    }

    public void setCompany(CompaniesEntity company) {
        this.company = company;
    }

    public DacEntity getDac() {
        return dac;
    }

    public void setDac(DacEntity dac) {
        this.dac = dac;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}