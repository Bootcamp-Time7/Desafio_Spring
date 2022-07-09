package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.exception.*;
import com.desafio.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IproductService{
    @Autowired
    ProductRepo repo;

    /**
     * author: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     * @return
     * @throws HandlerException
     * @throws Error
     */
    @Override
    public List<ProductRequestDTO> getProductAll() throws HandlerException, Error {
    try {
            List<Product> listProducts = repo.getProductAll();
            List<ProductRequestDTO> listProductsDTO = listProducts.stream()
                    .map(ProductRequestDTO::new).collect(Collectors.toList());
            return listProductsDTO;
        }catch (Exception e){
         throw  new ErrorCallListException(e.getMessage());
        }
    }

    /**
     * author: Marina
     * @param productList
     * @return
     */
    @Override
    public List<Product> getListForId(List<Product> productList) {
       return repo.getListForId(productList);
    }

    /**
     * author: Yago
     * @param products
     */
    @Override
    public void saveProductsVoid(List<Product> products) {
        repo.saveProductsVoid(products);
    }


    /**
     * author: Monica
     * @param category
     * @return
     */
    @Override
    public List<ProductRequestDTO> getAllByCategory(String category) {
        try {
                List<Product> listProducts = repo.getProductAll();
                List<ProductRequestDTO> listProductsDtoCategory = listProducts.stream()
                        .filter(productDto->productDto.getCategory().equalsIgnoreCase(category))
                        .map(ProductRequestDTO::new)
                        .collect(Collectors.toList());
                return listProductsDtoCategory;
            } catch (Exception e){
            throw new ErrorCallListException(e.getMessage());
        }
    }

    /**
     * author: Amanda
     * @param category
     * @param freeShipping
     * @param prestige
     * @return
     */
    @Override
    public List<ProductRequestDTO> getAllByFilters(Optional<String> category, boolean freeShipping, Optional<String> prestige) {
        List<ProductRequestDTO> lista = null;
            if (prestige.isPresent() && freeShipping && category.isPresent() ){
                throw  new ExcessiveFilter("Por favor, insira somente dois valores :  free shipping + category ou free shipping + prestige" );
            }
            if(category.isPresent() && freeShipping){
                return this.filterByCategoryFreeshipping( category.get(), true);
            }
            if(prestige.isPresent() && freeShipping){
                return  this.filterByPrestigeFreeshipping( prestige.get(), true);
            }
            if(!freeShipping){
                throw new NotFoundParamFreeshipping("Não é permitido sem selecionar free shipping");
            }
        return  lista;
    }

    /**
     * author: Amanda
     * @param category
     * @param freeShipping
     * @return
     */
    public   List<ProductRequestDTO> filterByCategoryFreeshipping( String category, boolean freeShipping ){
        try {
            List<ProductRequestDTO> list  =  this.getProductAll();

            List<ProductRequestDTO> listFilter = list.stream()
                    .filter(q -> q.getCategory().equals(category) && q.isFreeShipping())
                    .collect(Collectors.toList());
            return listFilter;
        } catch (Exception | HandlerException e){
           throw new FilterErrorException(e.getMessage());
      }
    }

    /**
     * author: Amanda
     * @param prestige
     * @param freeShipping
     * @return
     */
    public   List<ProductRequestDTO> filterByPrestigeFreeshipping( String prestige, boolean freeShipping ){
        try {
            List<ProductRequestDTO> list  =  this.getProductAll();
            int prestigeLength = prestige.length();
                if (prestige.length() <= 1) throw new Exception("Por favor, insira pelo menos uma estrela de avaliação");

            List<ProductRequestDTO> listFilter = list.stream()
                    .filter(q -> q.getPrestige().length() >= prestigeLength && q.isFreeShipping() )
                    .collect(Collectors.toList());
            return listFilter;
        } catch (Exception | HandlerException e){
            throw new FilterErrorException(e.getMessage());
        }
    }


    /**
     * author: Nicole
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */
    @Override
    public List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order) {
        try {
            List<Product> listProducts = repo.getProductAll();
            List<ProductRequestDTO> listProductsDTO = null;

            if(order == 0 ) {

                listProductsDTO = listProducts.stream()
                        .filter((product) -> product.getCategory().equalsIgnoreCase(category))
                        .filter((product) -> product.isFreeShipping())
                        .sorted((product1, product2) -> product1.getName().compareTo(product2.getName()))
                        .map(ProductRequestDTO::new)
                        .collect(Collectors.toList());


            } else if (order == 1) {
                listProductsDTO = listProducts.stream()
                        .filter((product) -> product.getCategory().equals(category))
                        .filter((product) -> product.isFreeShipping())
                        .sorted((product1, product2) -> product2.getName().compareTo(product1.getName()))
                        .map(ProductRequestDTO::new)
                        .collect(Collectors.toList());
            }
            return listProductsDTO;
        }catch (Exception e){
            throw new ErrorCallListException(e.getMessage());
        }
    }

    /**
     * author: Gabriel
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */
    @Override
    public List<ProductRequestDTO> getAllByHigherPrice(String category, boolean freeShipping, int order) {

        try{
            List<Product> listProducts = repo.getProductAll();
            List<ProductRequestDTO> listProductsDTO = null;

            if (order == 2){
                listProductsDTO = listProducts.stream()
                        .filter((product) -> product.getCategory().equalsIgnoreCase(category))
                        .filter((product) -> product.isFreeShipping())
                        .sorted((product1, product2) -> Double.valueOf(product2.getPrice()).compareTo(Double.valueOf(product1.getPrice()))) // ordem de preco
                        .map(ProductRequestDTO::new)
                        .collect(Collectors.toList());
            }
            return listProductsDTO;
        }catch (Exception e){
            throw  new ErrorCallListException(e.getMessage());
        }
    }

    /**
     * author: Gabriel
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */

    @Override
    public List<ProductRequestDTO> getAllByLowerPrice(String category, boolean freeShipping, int order) {
        try {
            List<ProductRequestDTO> listProductsDTO = null;
            List<Product> listProducts = repo.getProductAll();
            if (order == 3){
                listProductsDTO = listProducts.stream()
                        .filter((product) -> product.getCategory().equalsIgnoreCase(category))
                        .filter((product) -> product.isFreeShipping())
                        .sorted((product1, product2) -> Double.valueOf(product1.getPrice()).compareTo(Double.valueOf(product2.getPrice()))) // ordem de preco
                        .map(ProductRequestDTO::new)
                        .collect(Collectors.toList());
            }
            return listProductsDTO;
        } catch (Exception e){
            throw  new ErrorCallListException(e.getMessage());
        }
    }
}
