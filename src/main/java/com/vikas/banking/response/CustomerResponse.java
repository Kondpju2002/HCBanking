package com.vikas.banking.response;

public class CustomerResponse {
        private String name;
        private long customerId;
        private long accountId;
        private double balance;

    public CustomerResponse(String name, long customerId, long accountId, double balance) {
        this.name = name;
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
