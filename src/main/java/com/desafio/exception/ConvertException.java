package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ConvertException extends RuntimeException{
    static final  String message = "Internal Error of conversion !!";
    final HttpStatus code;
    final String description;


    public ConvertException(String description) {
        super(message);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
        this.description = description;

    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
