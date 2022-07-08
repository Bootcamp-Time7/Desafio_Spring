package com.desafio.Desafiospring.repository;
import com.desafio.Desafiospring.model.Product;
import com.desafio.exception.CreateException;
import com.desafio.exception.ErrorCallListException;
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

    /**
     *
     *  author: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     *  O presente método permite retorno de todos os valores do banco de dados, convertendo o arquivo json para uma lista do tipo Produto, reconhecida pelo java.
     *  return: List<Product>
     *
     */

     public List<Product> getProductAll(){
         List<Product> list = null;
         try {
             ObjectMapper mapperJson = new ObjectMapper();
             list = Arrays.asList(mapperJson.readValue( new File(fileJson), Product[].class));
         }catch (Exception e){
            throw new ErrorCallListException(e.getMessage());
         }
         return list;
     }

    /**
     *author: Yago
     * @param products
     */
    public void saveProductsVoid(List<Product> products){
        try{
            List<Product> tempList = null;
            ObjectMapper mapperJson = new ObjectMapper();
            ObjectWriter writerJson = mapperJson.writer(new DefaultPrettyPrinter());
            tempList = Arrays.asList(mapperJson.readValue(new File(fileJson),Product[].class));
            List<Product> copy = new ArrayList<>(tempList);

            products.stream()
                    .forEach(product -> copy.add(product));
            writerJson.writeValue(new File(fileJson),copy);
        }
        catch (Exception e){
            throw new CreateException(e.getMessage());
        }
    }

}
