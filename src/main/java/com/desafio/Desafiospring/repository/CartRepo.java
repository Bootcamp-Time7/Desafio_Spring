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

    private final String fileTicketJson="src/main/resources/cart.json";

    public List<Cart> getCartAll(){
        ObjectMapper mapperJson = new ObjectMapper();
        List<Cart> list = null;

        try {
            list = Arrays.asList(mapperJson.readValue( new File(fileTicketJson), Cart[].class));

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());

        }
        return list;
    }


    public void saveCart(Cart cart){
        ObjectMapper mapperJson = new ObjectMapper();
        ObjectWriter writerJson = mapperJson.writer(new DefaultPrettyPrinter());
        List<Cart> tempList = null;

        try{
            tempList = mapperJson.readValue(new File(fileTicketJson), new TypeReference<List<Cart>>(){});
            tempList.add(cart);
            writerJson.writeValue(new File(fileTicketJson),tempList);

        }
        catch (Exception e){
            System.out.println("Erro");
        }
    }




}
