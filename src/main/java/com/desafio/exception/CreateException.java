package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class CreateException extends RuntimeException {
    static final  String message = "Error creating on server ";
    final HttpStatus code;
    final String description;


    public CreateException(String description) {
        super(message);
        this.description = description;
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
