package com.vikas.banking.model;

public class Transactions {
    private long accId;
    private long toaccId;
    private String t;
    private double amount;

    public Transactions(long accId, long toaccId, String t, double amount) {
        this.accId = accId;
        this.toaccId = toaccId;
        this.t = t;
        this.amount = amount;
    }


    public long getAccId() {
        return accId;
    }

    public void setAccId(long accId) {
        this.accId = accId;
    }

    public long getToaccId() {
        return toaccId;
    }

    public void setToaccId(long toaccId) {
        this.toaccId = toaccId;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
