package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class CreateException extends RuntimeException {
    static final  String message = "Error creating on server ";
    final HttpStatus code;


    public CreateException() {
        super(message);

        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
