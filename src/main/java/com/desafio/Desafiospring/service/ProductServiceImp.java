package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
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
     *
     * @return
     */
    @Override
    public List<ProductRequestDTO> getProductAll() {
        List<Product> listProducts = repo.getProductAll();
        List<ProductRequestDTO> listProductsDTO = listProducts.stream()
                .map(ProductRequestDTO::new).collect(Collectors.toList());
        return listProductsDTO;
    }

    /**
     *
     * @param products
     */
    @Override
    public void saveProductsVoid(List<Product> products) {
        repo.saveProductsVoid(products);

    }

    @Override
    public List<ProductResponseDTO> saveProducts(List<Product> products) {
        return null;
    }

    @Override
    public List<CartRequestDTO> createShoppingCart(List<ProductResponseDTO> products) {
        return null;
    }

    @Override
    public List<ProductRequestDTO> getAllByCategory(String category) {
        return null;
    }

    /**
     *
     * @param category
     * @param freeShipping
     * @param prestige
     * @return
     */
    @Override
    public List<ProductRequestDTO> getAllByFilters(Optional<String> category, Optional<Boolean> freeShipping, Optional<String> prestige) {
        List<ProductRequestDTO> lista = null;

        try {
            List<ProductRequestDTO> list  =  this.getProductAll();
            if(category.isPresent() && freeShipping.isPresent()){
                return this.filterByCategoryFreeshipping(list, category.get(), true);
            }
            if(prestige.isPresent() && freeShipping.isPresent()){
                return  this.filterByPrestigeFreeshipping(list, prestige.get(), true);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

         return lista;
    }

    /**
     *
     * @param list
     * @param category
     * @param freeShipping
     * @return
     */
    public   List<ProductRequestDTO> filterByCategoryFreeshipping( List<ProductRequestDTO> list, String category, boolean freeShipping ){
        List<ProductRequestDTO> lista = null;
        try {
            List<ProductRequestDTO> listFilter = list.stream()
                    .filter(q -> q.getCategory().equals(category) && q.isFreeShipping())
                    .collect(Collectors.toList());

            return listFilter;
        } catch (Exception e){
            System.out.println(e.getMessage());
      }
        return lista;
    }


    public   List<ProductRequestDTO> filterByPrestigeFreeshipping( List<ProductRequestDTO> list, String prestige, boolean freeShipping ){
        List<ProductRequestDTO> lista = null;
        try {
            int prestigeLength = prestige.length();
                if (prestige.length() <= 1) throw new Exception("Por favor, insira pelo menos uma estrela de avaliação");

            List<ProductRequestDTO> listFilter = list.stream()
                    .filter(q -> q.getPrestige().length() >= prestigeLength && q.isFreeShipping() )
                    .collect(Collectors.toList());
            return listFilter;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }


    //TODO criar uma classe ParamOrderAlphabetic para aceitar o alfabético crescente => 0, alfabético decrescente => 1
    @Override
    public List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order) {
        return null;
    }


    //TODO criar uma variavel final na interface para aceitar o preço crescente => 3, preço decrescente => 2, criar uma exceçao para receber somente os valores esperados
    @Override
    public List<ProductRequestDTO> getAllByHigherPrice(String category, boolean freeShipping, int order) {
        return null;
    }

    //TODO criar uma variavel final na interface para aceitar o preço crescente => 3, preço decrescente => 2, criar uma exceçao para receber somente os valores esperados
    @Override
    public List<ProductRequestDTO> getAllByLowerPrice(String category, boolean freeShipping, int order) {
        return null;
    }




}
