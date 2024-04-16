package com.vikas.banking.response;

import lombok.Data;

@Data
public class TransactionResponse {

    private String s ;
    private String error;

    private long Transfer_ID;

    public TransactionResponse(String s, String error, long transfer_ID) {
        this.s = s;
        this.error = error;
        Transfer_ID = transfer_ID;
    }


}
