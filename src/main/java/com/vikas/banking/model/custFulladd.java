package com.vikas.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class custFulladd {

    @Id
    private  String country;
    private  String city;
    private  String addressLane;
    private  long pin;
    private  long phonenum;
    private  String email;

    private  String name;

    public custFulladd() {

    }
    public custFulladd(String name, String country, String city, String addressLane, long pin, long phonenum, String email) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.addressLane = addressLane;
        this.pin = pin;
        this.phonenum = phonenum;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddressLane() {
        return addressLane;
    }

    public void setAddressLane(String addressLane) {
        this.addressLane = addressLane;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
