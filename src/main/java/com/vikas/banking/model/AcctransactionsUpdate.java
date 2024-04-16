package com.vikas.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table
public class AcctransactionsUpdate {



    @Id
    private long acc_Id;

    private long transactionId;

    private long trans_ref_Id;
    private double credit;
    private double debit;
    private double avail_balance;
    private Timestamp date;

    public AcctransactionsUpdate(long acc_Id, long transactionId, long trans_ref_Id, double credit, double debit, double avail_balance, Timestamp date) {
        this.acc_Id = acc_Id;
        this.transactionId = transactionId;
        this.trans_ref_Id = trans_ref_Id;
        this.credit = credit;
        this.debit = debit;
        this.avail_balance = avail_balance;
        this.date = date;
    }

    public AcctransactionsUpdate() {

    }


    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getAcc_Id() {
        return acc_Id;
    }

    public void setAcc_Id(long acc_Id) {
        this.acc_Id = acc_Id;
    }

    public long getTrans_ref_Id() {
        return trans_ref_Id;
    }

    public void setTrans_ref_Id(long trans_ref_Id) {
        this.trans_ref_Id = trans_ref_Id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getAvail_balance() {
        return avail_balance;
    }

    public void setAvail_balance(double avail_balance) {
        this.avail_balance = avail_balance;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
