package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.model.Product;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {

    private final  String fileJson = "src/main/resources/products.json";

     public List<Product> getProductAll(){
         List<Product> lista = null;
         ObjectMapper mapper = new ObjectMapper();
         try{
             lista = Arrays.asList
                     (mapper.readValue(new File(fileJson), Product[].class));
             return lista;

         } catch (Exception ex) {
             System.out.println("Erro");
         }
         return lista;
     }

     public void saveProducts(List<Product> products) {
         ObjectMapper mapper = new ObjectMapper();
         ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

         List<Product> tempList;

         try {
             tempList = Arrays.asList(mapper.readValue(new File(fileJson), Product[].class));
             List<Product> copy = new ArrayList<>(tempList);
             products.stream().forEach(p-> copy.add(p));
             writer.writeValue(new File(fileJson), copy);

         } catch (Exception ex) {
             System.out.println("Erro");
         }
     }
}

