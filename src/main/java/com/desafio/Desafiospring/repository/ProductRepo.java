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

    /**
     *
     *  @author: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     *  O presente método permite retorno de todos os valores do banco de dados, convertendo o arquivo json para uma lista do tipo Produto, reconhecida pelo java.
     *  @return: List<Product>
     *
     */


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

    /**
     *
     * @author: Yago
     * O presente método permite que seja salva a lista de produtos no banco de dados
     * @param:
     * @return: List<Product>
     *
     */

     public List<Product> saveProducts(List<Product> products){
         //TODO CONTINUAR
         return null;
     }

}
