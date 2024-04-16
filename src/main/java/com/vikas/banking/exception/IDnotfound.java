package com.vikas.banking.exception;

import lombok.Data;

@Data
public class IDnotfound {

    private String message ;
    private String code;
    public IDnotfound(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public IDnotfound() {
    }
}
