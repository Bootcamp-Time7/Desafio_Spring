package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.model.Cart;
import com.desafio.Desafiospring.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CartRepo {

    private static final String fileTicketJson="src/main/resources/cart.json";

    /**
     *
     * @return
     */
    public List<Cart> getCartAll(){
        ObjectMapper mapper = new ObjectMapper();
        List<Cart> list = null;

        try {
            list = Arrays.asList(mapper.readValue(new File(fileTicketJson), Cart[].class));

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());

        }
        return list;
    }

    /**
     *
     * @param cart
     */
    public void saveCart(Cart cart){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try{
            Cart[] cartTemp = mapper.readValue(new File(fileTicketJson), Cart[].class);
            List<Cart> copy = new ArrayList<>(List.of(cartTemp));
            copy.add(cart);
            writer.writeValue(new File(fileTicketJson), copy);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erro");
        }
        //TODO        throw new exeption;
    }

}
