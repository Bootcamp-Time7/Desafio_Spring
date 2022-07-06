package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.Data;

@Data
public class ProductResponseDTO {

    private long productId;
    private String name;
    private int quantity;

    public ProductResponseDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();

    }



}
