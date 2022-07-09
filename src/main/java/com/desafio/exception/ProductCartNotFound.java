package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ProductCartNotFound extends  RuntimeException{

        static final  String message = "Product in cart not disponible!!";
        final HttpStatus code;
        final String description;


        public ProductCartNotFound(String description) {
            super(message);
            this.code = HttpStatus.INTERNAL_SERVER_ERROR;
            this.description = description;

        }
        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }


