package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.handler.HandlerException;

import java.util.List;
import java.util.Optional;

public interface IproductService {

    void saveProductsVoid(List<Product> products);
    List<Product> getListForId(List<Product> productList);
    List<ProductRequestDTO> getProductAll() throws HandlerException, Error;
    List<ProductRequestDTO> getAllByCategory(String category);
    List<ProductRequestDTO> getAllByFilters(Optional<String> category, boolean freeShipping, Optional<String> prestige);
    List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order );
    List<ProductRequestDTO> getAllByHigherPrice(String category, boolean freeShipping, int order );
    List<ProductRequestDTO> getAllByLowerPrice(String category, boolean freeShipping, int order );




}
