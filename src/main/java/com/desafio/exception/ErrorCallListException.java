package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ErrorCallListException extends  RuntimeException{
    static final  String message = "Error call list in server ";
    final HttpStatus code;


    public ErrorCallListException() {
        super(message);

        this.code = HttpStatus.NOT_FOUND;
    }


}

