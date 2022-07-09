package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class ProductRequestDTO  implements Comparable <ProductRequestDTO> {
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

@Override
public int compareTo(ProductRequestDTO compare){
    if (this.price > compare.getPrice()) {
        return 1;
    } 

    if (this.price < compare.getPrice()) {
        return -1;
    }

    return 0;
}

}
