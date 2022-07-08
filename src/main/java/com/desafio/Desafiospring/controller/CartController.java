package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.model.Purchase;
import com.desafio.Desafiospring.repository.CartRepo;
import com.desafio.Desafiospring.service.CartServiceImp;
import com.desafio.Desafiospring.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping("/purchase-request")
    public ResponseEntity <CartRequestDTO> cartRequestShopping (List<Purchase>cartPurchase){

        cartService.createShoppingCart( cartPurchase);
        return null;
    }

}
