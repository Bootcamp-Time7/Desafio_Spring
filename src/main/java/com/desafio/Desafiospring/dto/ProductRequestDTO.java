package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.Data;

@Data
public class ProductRequestDTO  {
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


//    @Override
//    public int compareTo(String prestige) {
//        if(this.getPrestige().length() >= prestige.length())
//            return 1;
//        if(this.getPrestige().length() <= prestige.length())
//            return 1;
//        return 0;    }
}
