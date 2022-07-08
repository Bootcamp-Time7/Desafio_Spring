package com.desafio.Desafiospring.model;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Cart {
    private long id;
    private List<Product> articles;
    private double total;
}


