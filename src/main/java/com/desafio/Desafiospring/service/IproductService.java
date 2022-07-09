package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.handler.HandlerException;

import java.util.List;
import java.util.Optional;

public interface IproductService {

    void saveProductsVoid(List<Product> products);
    //TODO Criar DTO para response e request do carrinho

    List<CartRequestDTO> createShoppingCart(List<ProductResponseDTO> products);
    

    List<Product> getListForId(List<Product> productList);
    List<ProductRequestDTO> getProductAll() throws HandlerException, Error;
    List<ProductRequestDTO> getAllByCategory(String category);
    List<ProductRequestDTO> getAllByFilters(Optional<String> category, boolean freeShipping, Optional<String> prestige);
    List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order );

    //TODO criar uma variavel final na interface para aceitar o preço crescente => 3, preço decrescente => 2, criar uma exceçao para receber somente os valores esperados
    List<ProductRequestDTO> getAllByHigherPrice(String category, boolean freeShipping, int order );
    List<ProductRequestDTO> getAllByLowerPrice(String category, boolean freeShipping, int order );




}
