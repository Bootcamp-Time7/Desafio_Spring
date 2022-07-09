package com.desafio.Desafiospring.model;

import lombok.*;

import java.util.List;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private long id;
    private List<Product> articles;
    private double total;

}
