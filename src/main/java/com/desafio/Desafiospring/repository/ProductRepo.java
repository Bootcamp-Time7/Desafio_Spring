package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
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

     public List<Product> saveProducts(List<Product> products){
         //TODO CONTINUAR
         return null;
     }
     
    //  public List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order ) {
    //     ObjectMapper mapperJson = new ObjectMapper();
    //     List<ProductRequestDTO> list = null;

    //     try {
    //         list = Arrays.asList(mapperJson.readValue( new File(fileJson), ProductRequestDTO[].class));
        
    //     }catch (Exception e){
    //         System.out.println(e.getMessage());
    //         System.out.println(e.getCause());

    //     }
    //     return list;
    //  }

}
