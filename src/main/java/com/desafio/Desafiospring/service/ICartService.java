package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartResponseDTO;
import com.desafio.Desafiospring.model.Purchase;

import java.util.List;

public interface ICartService {

    CartResponseDTO createShoppingCart(List<Purchase> purchaseList);
}
