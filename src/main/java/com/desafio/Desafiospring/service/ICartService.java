package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.model.Purchase;

import java.util.HashMap;
import java.util.List;

public interface ICartService {

    List<Product> createShoppingCart(List<Purchase> cartPurchase);
}
