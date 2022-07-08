package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.model.Purchase;
import com.desafio.Desafiospring.repository.CartRepo;
import com.desafio.Desafiospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CartServiceImp implements ICartService{

    @Autowired
    ProductRepo repoProduct;

    @Autowired
    CartRepo repoCart;

    @Override
    public List<Product> createShoppingCart(List<Purchase> cartPurchase ) {

        List<Product> purchaseList = new ArrayList<>();
        List<Product> productList =  repoProduct.getProductAll();
        //List<Cart> productCartList = repoCart.getCartProductAll();
        cartPurchase.stream()
                .forEach(purchase -> {
                    productList.forEach(product -> {
                        if(   product.getProductId() == purchase.getProductPurchaseId()){
                            product.setQuantity(purchase.getQuantity());

                            purchaseList.add(product);
                        }

                    });
                });

                Cart cartCarrinho= Cart.builder()
                               .id(123)
                               .articles(purchaseList)
                               .total(2536)
                               .build();

          repoCart.saveCartProducts(cartCarrinho);

          return null;

    }

    public double calcularTotal(List<Product> produtos){
        double total=0;
        for(Product produto :produtos){
            total+=produto.getPrice()*produto.getQuantity();
        }
       return total;
    }
}
