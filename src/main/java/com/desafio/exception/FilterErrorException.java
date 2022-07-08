package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class FilterErrorException extends  RuntimeException{
    static final  String message = "Error when filtering the data on the server";
    final HttpStatus code;


    public FilterErrorException() {
        super(message);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
