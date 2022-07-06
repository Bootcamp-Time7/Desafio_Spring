package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepo {

    private final  String fileJson = "src/main/resources/products.json";

     public List<Product> getProductAll(){
         ObjectMapper mapperJson = new ObjectMapper();
         List<Product> list = null;

         try {
             list = Arrays.asList(mapperJson.readValue( new File(fileJson), Product[].class));

         }catch (Exception e){
             System.out.println(e.getMessage());
             System.out.println(e.getCause());

         }
         return list;
     }

}
