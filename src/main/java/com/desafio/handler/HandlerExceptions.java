package com.desafio.handler;

import com.desafio.exception.NotFoundExceptions;
import com.desafio.exception.NotFoundExceptionsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(NotFoundExceptions.class)

    public ResponseEntity<NotFoundExceptionsDetails> handlerNotFoundEx (NotFoundExceptions notFound){
        return new ResponseEntity<>(
                NotFoundExceptionsDetails.builder()
                        .titulo("Produto não encontrado")
                        .status(HttpStatus.NOT_FOUND.value())
                        .mensagem(notFound.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND);
    }

}
