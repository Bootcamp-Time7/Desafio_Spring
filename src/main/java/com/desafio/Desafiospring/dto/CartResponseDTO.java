package com.desafio.Desafiospring.dto;

import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
public class CartResponseDTO {
    private long id;
    private List<Product> articles;
    private double total;


    public CartResponseDTO (Cart cart){
        this.id = cart.getId();
        this.articles = cart.getArticles();
        this.total = cart.getTotal();
    }

    public static CartResponseDTO convertIntoCartDTO(Cart cart){
        return new CartResponseDTO(cart);
    }
}
