package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.model.Purchase;

import java.util.List;

public interface ICartService {

    CartRequestDTO createShoppingCart(List<Purchase> purchaseList);
}
