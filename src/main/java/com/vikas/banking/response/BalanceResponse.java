package com.vikas.banking.response;

public class BalanceResponse {
    private long accId;
    private double accBalance;

    public BalanceResponse(long accId, double accBalance) {
        this.accId = accId;
        this.accBalance = accBalance;
    }

    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }
}
