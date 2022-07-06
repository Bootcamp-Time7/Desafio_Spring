package com.desafio.Desafiospring.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {
    private int id;
    private List<ProductRequestDTO> articles;
    private double total;

}
