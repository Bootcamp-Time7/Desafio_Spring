package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class NotFoundParamFreeshipping extends RuntimeException {
    static final  String message = "Free shipping is mandatory !!";
    final HttpStatus code;
    final String description;

    public NotFoundParamFreeshipping(String description) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST;
        this.description = description;

    }

}
