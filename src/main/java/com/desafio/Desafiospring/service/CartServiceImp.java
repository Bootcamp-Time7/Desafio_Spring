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
    public CartRequestDTO createShoppingCart(List<Purchase> purchaseList) {
        List<Product> productList = convertPurchaseIntoCart(purchaseList);
        Cart cart = Cart.builder()
                .id(repoCart.getCartAll().size() + 1)
                .articles(productList)
                .total(calculoTotalCompra(productList))
                .build();
        repoCart.saveCart(cart);
        return null;
    }


    private Product findById(Purchase purchase) {
        List<Product> productList = repoProduct.getProductAll();
        for (Product p : productList) {
            if (p.getProductId() == purchase.getId()) {
                if (p.getQuantity() >= purchase.getQuantity()) {
                    return p;
                } else {
                    System.out.println("Produto indisponível");
                }
            }
        }
        // TODO Throw new exception
        return null;
    }

    private List<Product> convertPurchaseIntoCart(List<Purchase> purchaseList){
        List<Product> productList = new ArrayList<>();
        for (Purchase purchase: purchaseList){
            Product p = findById(purchase);
            p.setQuantity(purchase.getQuantity());
            productList.add(p);
        }
        return productList;
    }

    public Double calculoTotalCompra (List<Product> list){
        return list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }
}
