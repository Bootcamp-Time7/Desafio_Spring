package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.CartRepo;
import com.desafio.Desafiospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CartServiceImp implements ICartService{

    @Autowired
    ProductRepo repoProduct;

    @Autowired
    CartRepo repoCart;

    @Override
    public CartRequestDTO createShoppingCart(HashMap<Integer,Integer> productHashList) {
        List<Product> productList =  repoProduct.getProductAll();
        List<Product> listArticles=null;
        productList.stream()
                    .forEach(product -> {
                        if(productHashList.containsKey(product.getProductId())){
                            listArticles.add(product);
                        }
                    });

        CartRequestDTO cartRequestDTO = new CartRequestDTO(listArticles);


        return cartRequestDTO;
    }
}
