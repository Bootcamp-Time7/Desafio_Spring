package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class NotFoundParamFreeshipping extends RuntimeException {
    static final  String message = "Free shipping is mandatory !!";
    final HttpStatus code;


    public NotFoundParamFreeshipping() {
        super(message);
        this.code = HttpStatus.BAD_REQUEST;
    }

}
