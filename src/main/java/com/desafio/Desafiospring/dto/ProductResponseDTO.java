package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<ProductResponseDTO> convertForListProdRespDTO (List<Product> productList){
        return productList.stream().map(ProductResponseDTO::new).collect(Collectors.toList());
    }

}
