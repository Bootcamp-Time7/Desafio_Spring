package com.desafio.Desafiospring.repository;

import com.desafio.Desafiospring.dto.ProductRequestDTO;

import com.desafio.Desafiospring.model.Product;
import com.desafio.exception.CreateException;
import com.desafio.exception.ErrorCallListException;
import com.desafio.exception.NotFoundException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepo {

    private final  String fileJson = "src/main/resources/products.json";

    /**
     * author: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     * @return
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
     * author: Yago
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

    /**
     * author: marina
     * @param productList
     * @return
     */
    public List<Product> getListForId(List<Product> productList) {
        List<Product> listAllProducts = getProductAll();
        return productList.stream().map(p -> getProductById(p.getProductId())).collect(Collectors.toList());
    }

    /**
     * author : marina
     * @param id
     * @return
     */
    public Product getProductById(long id) {
        List<Product> lista = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            lista = Arrays.asList
                    (mapper.readValue(new File(fileJson), Product[].class));
            for(Product p: lista){
                if(p.getProductId() == id){
                    return p;
                }
            }
        } catch (Exception ex) {
            throw new NotFoundException("Produto não localizado");
        }
        return null;
    }

}
