package com.desafio.Desafiospring.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Cart {

    private long id;
    private List<Product> articles;
    private double total;;

}
