package com.vikas.banking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table

public class Custaddress {

    @Id
    private Long AddressId;
    private String country;
    private String city;
    private String AddresLane;
    private  Long Pin;

    private Timestamp LastUpdatedate;

    public Custaddress(Long addressId, String country, String city, String addresLane, Long pin, Timestamp lastUpdate) {
        AddressId = addressId;
        this.country = country;
        this.city = city;
        AddresLane = addresLane;
        Pin = pin;
        LastUpdatedate = lastUpdate;
    }

    public Custaddress() {
    }

    public Long getAddressId() {
        return AddressId;
    }

    public void setAddressId(Long addressId) {
        AddressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddresLane() {
        return AddresLane;
    }

    public void setAddresLane(String addresLane) {
        AddresLane = addresLane;
    }

    public Long getPin() {
        return Pin;
    }

    public void setPin(Long pin) {
        Pin = pin;
    }

    public Timestamp getLastUpdatedate() {
        return LastUpdatedate;
    }

    public void setLastUpdatedate(Timestamp lastUpdatedate) {
        LastUpdatedate = lastUpdatedate;
    }


}
