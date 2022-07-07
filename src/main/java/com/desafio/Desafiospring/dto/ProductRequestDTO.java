package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private long productId;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;

    public ProductRequestDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.freeShipping = product.isFreeShipping();
        this.prestige = product.getPrestige();
    }

    public static Product convertProductRequestDTO(ProductRequestDTO productRequestDTO) {
        return Product.builder()
                .productId(productRequestDTO.getProductId())
                .name(productRequestDTO.getName())
                .category(productRequestDTO.getCategory()).brand(productRequestDTO.getBrand())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .freeShipping(productRequestDTO.isFreeShipping())
                .prestige(productRequestDTO.getPrestige()).build();
    }

    public static List<Product> convertListProductRequest(List<ProductRequestDTO> listProductRequest){
        return listProductRequest.stream().map(ProductRequestDTO::convertProductRequestDTO).collect(Collectors.toList());
    }
    public static List<ProductRequestDTO> convertListProduct(List<Product> listProduct) {
        List<ProductRequestDTO> listaResponseDTO = listProduct.stream().map(ProductRequestDTO::new).collect(Collectors.toList());
        return listaResponseDTO;
    }
}
