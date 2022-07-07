package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;

import java.util.List;

public interface IproductService {
    void saveProductsVoid(List<Product> products);
    List<ProductResponseDTO> saveProducts(List<Product> products);

    //TODO Criar DTO para response e request do carrinho
    List<CartRequestDTO> createShoppingCart(List<ProductResponseDTO> products);
    List<ProductRequestDTO> getProductAll();
    List<ProductRequestDTO> getAllByCategory(String category);

    //TODO Criar uma classe generica para o filtro de dois produtos, criar uma exceçao para nao receber quantidade
    List<ProductRequestDTO> getAllByTwoFilters(String firstFilter,  boolean secondFilter);

    //TODO criar uma classe ParamOrderAlphabetic para aceitar o alfabético crescente => 0, alfabético decrescente => 1
    List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order );

    //TODO criar uma variavel final na interface para aceitar o preço crescente => 3, preço decrescente => 2, criar uma exceçao para receber somente os valores esperados
    List<ProductRequestDTO> getAllByHigherPrice(String category, boolean freeShipping, int order );
    List<ProductRequestDTO> getAllByLowerPrice(String category, boolean freeShipping, int order );




}
