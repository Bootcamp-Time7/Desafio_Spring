package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;

import java.util.HashMap;
import java.util.List;

public interface ICartService {

    CartRequestDTO createShoppingCart(HashMap<Integer,Integer> productHashList);
}
