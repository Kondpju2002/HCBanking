package com.vikas.banking.model;


import jakarta.persistence.*;

@Entity
@Table
public class Accbalance {

    @Id
    private long accountId;
    private double balance;

    public Accbalance(long accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public Accbalance() {

    }

    public long getAccId() {
        return accountId;
    }

    public void setAccId(long accId) {
        this.accountId = accId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @OneToOne
    @JoinColumn(name="Account_Balance")
    private CustomerAccMap custbalance;
}
