package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ExcessiveFilter extends RuntimeException{

        static final  String message = "Excessive filter, free shipping is only mandatory, use prestige or category!!";
        final HttpStatus code;
        final String description;


    public ExcessiveFilter(String description) {
            super(message);
            this.code = HttpStatus.INTERNAL_SERVER_ERROR;
            this.description = description;

    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
