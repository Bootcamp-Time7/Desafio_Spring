package com.desafio.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionsDetails {
    private String titulo;
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
