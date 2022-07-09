package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.Data;

import java.util.List;

@Data

public class CartRequestDTO {

    private List<Product> articles;

}
