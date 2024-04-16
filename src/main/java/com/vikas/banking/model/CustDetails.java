package com.vikas.banking.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table

public class CustDetails {

    @Id
    private Long custId;
    private String name;
    private long addId;
    private long phonenum;
    private String Email;
    private Timestamp created;
    private Timestamp lastUp;

    public CustDetails(Long custId, String name, long addId, long phonenum, String email, Timestamp created, Timestamp lastUp) {
        this.custId = custId;
        this.name = name;
        this.addId = addId;
        this.phonenum = phonenum;
        Email = email;
        this.created = created;
        this.lastUp = lastUp;
    }

    public CustDetails() {

    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAddId() {
        return addId;
    }

    public void setAddId(long addId) {
        this.addId = addId;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastUp() {
        return lastUp;
    }

    public void setLastUp(Timestamp lastUp) {
        this.lastUp = lastUp;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Address_id")
    private Custaddress custadd;





}
