package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CartRepo {
    private final  String fileTicketJson="src/main/resources/cart.json";

    public List<Cart> getCartProductAll(){
        ObjectMapper mapperCartJson = new ObjectMapper();


        try {
            List<Cart> cartList = null;
            cartList = Arrays.asList(mapperCartJson.readValue( new File(fileTicketJson), Cart[].class));
        }

        catch (Exception ex) {
            System.out.println("erro");

        }
        return null;
    }


    public void saveCartProducts(Cart productsCart){
        ObjectMapper mapperCartJson = new ObjectMapper();
        ObjectWriter writerJson = mapperCartJson.writer(new DefaultPrettyPrinter());
        List<Cart> cartTempList = null;

        try{
            cartTempList = mapperCartJson.readValue(new File(fileTicketJson), new TypeReference<List<Cart>>(){});
            //List<Cart> copy = new ArrayList<>(cartTempList);

            cartTempList.add(productsCart);
            writerJson.writeValue(new File(fileTicketJson),cartTempList);

        }
        catch (Exception e){
            System.out.println("Erro");
        }
    }


}
