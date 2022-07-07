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

    /**
     *
     * @param products
     */
    public void saveProductsVoid(List<Product> products){
        ObjectMapper mapperJson = new ObjectMapper();
        ObjectWriter writerJson = mapperJson.writer(new DefaultPrettyPrinter());
        List<Product> tempList = null;

        try{
            tempList = Arrays.asList(mapperJson.readValue(new File(fileJson),Product[].class));
            List<Product> copy = new ArrayList<>(tempList);

            products.stream()
                    .forEach(product -> copy.add(product));
            writerJson.writeValue(new File(fileJson),copy);


        }
        catch (Exception e){
            System.out.println("Erro");
        }
    }

}
