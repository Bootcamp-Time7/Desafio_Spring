package com.desafio.Desafiospring.model;


import lombok.Data;

@Data
public class Product {

    private long productId;
    private String name;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private boolean freeShipping;
    private String prestige;
}
