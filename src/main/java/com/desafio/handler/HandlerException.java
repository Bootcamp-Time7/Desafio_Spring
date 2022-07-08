package com.desafio.handler;

import com.desafio.exception.NotFoundException;
import com.desafio.exception.ExceptionsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(NotFoundException.class)

    public ResponseEntity<ExceptionsDetails> handlerNotFoundProduct(NotFoundException notFound){
        return new ResponseEntity<>(
                ExceptionsDetails.builder()
                        .titulo("Produto não encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .mensagem(notFound.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

}
