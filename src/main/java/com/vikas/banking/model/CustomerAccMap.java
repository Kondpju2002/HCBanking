package com.vikas.banking.model;

import jakarta.persistence.*;

@Entity
@Table

public class CustomerAccMap {
    @Id

    private long accId;
    private long custId;

    public CustomerAccMap() {

    }

    public CustomerAccMap(long accId, long custId) {
        this.accId = accId;
        this.custId = custId;
    }


    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @OneToOne
    @JoinColumn(name="Customer_id")
    private CustDetails cd;




}
