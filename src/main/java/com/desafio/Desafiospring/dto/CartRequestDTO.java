package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {
    private int id;
    private List<Product> articles;
    private double total;
    private static int count=0;



    public CartRequestDTO (List <Product> list){
        this.id=count;
        this.articles=list;
        this.total=calculoTotalCompra(list);


    }

    public static double calculoTotalCompra (List <Product> list){
       double valorTotal= list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
       return valorTotal;
    }
}
