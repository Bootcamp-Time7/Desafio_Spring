package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ErrorCallListException extends  RuntimeException{
    static final  String message = "Error call list in server ";
    final HttpStatus code;
    final String description;


    public ErrorCallListException(String description) {
        super(message);
        this.description = description;
        this.code = HttpStatus.NOT_FOUND;
    }


}

