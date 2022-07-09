package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.CartResponseDTO;
import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.model.Purchase;
import com.desafio.Desafiospring.repository.CartRepo;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.exception.ConvertException;
import com.desafio.exception.CreateException;
import com.desafio.exception.ErrorCallListException;
import com.desafio.exception.ProductCartNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements ICartService{

    @Autowired
    ProductRepo repoProduct;

    @Autowired
    CartRepo repoCart;

    @Override
    public CartResponseDTO createShoppingCart(List<Purchase> purchaseList) {
        try{
            List<Product> productList = convertPurchaseIntoCart(purchaseList);
            Cart cart = Cart.builder()
                    .id(repoCart.getCartAll().size() + 1)
                    .articles(productList)
                    .total(calculoTotalCompra(productList))
                    .build();
            repoCart.saveCart(cart);
            return CartResponseDTO.convertIntoCartDTO(cart);
        }catch (Exception e ){
            throw new CreateException(e.getMessage());
        }

    }


    private Product findById(Purchase purchase) {
        try {
            List<Product> productList = repoProduct.getProductAll();
            for (Product p : productList) {
                if (p.getProductId() == purchase.getId()) {
                    if (p.getQuantity() >= purchase.getQuantity()) {
                        return p;
                    } else {
                        throw new ProductCartNotFound("Produto não disponível");
                    }
                }
            }
        }catch (Exception e ){
            throw new ErrorCallListException(e.getMessage());
        }
        return null;
    }

    private List<Product> convertPurchaseIntoCart(List<Purchase> purchaseList){
        try {
            List<Product> productList = new ArrayList<>();
            for (Purchase purchase: purchaseList){
                Product p = findById(purchase);
                p.setQuantity(purchase.getQuantity());
                productList.add(p);
            }
            return productList;
        }catch (Exception e){
            throw new ConvertException(e.getMessage());
        }
    }

    public Double calculoTotalCompra (List<Product> list){
        return list.stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum();
    }
}
