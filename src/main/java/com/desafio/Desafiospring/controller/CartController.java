package com.desafio.Desafiospring.controller;


import com.desafio.Desafiospring.dto.CartResponseDTO;
import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Purchase;
import com.desafio.Desafiospring.service.ICartService;
import com.desafio.Desafiospring.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {
    @Autowired
    ICartService cartService;

    @Autowired
    IproductService iproductService;

    @PostMapping("/purchase-request")
    public ResponseEntity <CartResponseDTO> cartRequestShopping (@RequestBody List<Purchase> purchaseList){
        CartResponseDTO cartResponseDTO = cartService.createShoppingCart(purchaseList);
        return ResponseEntity.ok(cartResponseDTO);
    }

}
