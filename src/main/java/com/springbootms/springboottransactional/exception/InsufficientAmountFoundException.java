package com.springbootms.springboottransactional.exception;

public class InsufficientAmountFoundException extends RuntimeException {

    public InsufficientAmountFoundException(String str) {
        super(str);
    }
}
