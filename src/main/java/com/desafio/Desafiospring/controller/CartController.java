package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.repository.CartRepo;
import com.desafio.Desafiospring.service.CartServiceImp;
import com.desafio.Desafiospring.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/purchase-request")
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping
    public ResponseEntity <CartRequestDTO> cartRequestShopping (Integer id, Integer quantity){
        cartService.createShoppingCart(id, quantity)
    }

}
