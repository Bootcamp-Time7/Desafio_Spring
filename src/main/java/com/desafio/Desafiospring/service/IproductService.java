package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.ProductRequestDTO;

import java.util.List;

public interface IproductService {

    List<ProductRequestDTO> getProductAll();
}
