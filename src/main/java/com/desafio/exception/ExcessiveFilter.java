package com.desafio.exception;

import org.springframework.http.HttpStatus;

public class ExcessiveFilter extends RuntimeException{

        static final  String message = "Excessive filter, free shipping is only mandatory, use prestige or category!!";
        final HttpStatus code;


        public ExcessiveFilter() {
            super(message);
            this.code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
}
