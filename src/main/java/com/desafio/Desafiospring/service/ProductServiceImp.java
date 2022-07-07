package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IproductService{

    @Autowired
    ProductRepo repo;

    @Override
    public List<ProductRequestDTO> getProductAll() {
        List<Product> listProducts = repo.getProductAll();
        List<ProductRequestDTO> listProductsDTO = listProducts.stream()
                .map(ProductRequestDTO::new).collect(Collectors.toList());
        return listProductsDTO;
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


    //TODO Criar uma classe generica para o filtro de dois produtos, criar uma exceçao para nao receber quantidade
    @Override
    public List<ProductRequestDTO> getAllByTwoFilters(String firstFilter, boolean secondFilter) {
        return null;
    }


    //TODO criar uma classe ParamOrderAlphabetic para aceitar o alfabético crescente => 0, alfabético decrescente => 1

    /**
     * @author: Nicole Calderari
     * Esse método faz o filtro dos produtos baseado nos parâmetros que chegam pela requisição do usuário e ordena alfabeticamente,
     * Transforma a lista de produtos em Steam e aplica as HOF`S de filtro para pegar os produtos de acordo com os parâmetros passados
     * depois ordena alfabeticamente de A-Z ou Z-A, dependendo do número que foi passado pelo param Order.
     * Retorna os produtos filtrados e convertidos para DTO.
     */
    @Override
    public List<ProductRequestDTO> getAllByAlphabetic(String category, boolean freeShipping, int order) {
        List<Product> listProducts = repo.getProductAll(); // colocar método que a Mônica ainda vai fazer
        List<ProductRequestDTO> listProductsDTO = null;

        if(order == 0 ) {

           listProductsDTO = listProducts.stream()
           .filter((product) -> product.getCategory().equalsIgnoreCase(category)) // ai deleta essa linha.
           .filter((product) -> product.isFreeShipping())
           .sorted((product1, product2) -> product1.getName().compareTo(product2.getName())) // ordem alfabética normal
           .map(ProductRequestDTO::new)
           .collect(Collectors.toList());
         

        } else if (order == 1) {
            listProductsDTO = listProducts.stream()
            .filter((product) -> product.getCategory().equals(category)) 
            .filter((product) -> product.isFreeShipping())
            .sorted((product1, product2) -> product2.getName().compareTo(product1.getName())) // de trás pra frente
            .map(ProductRequestDTO::new)
            .collect(Collectors.toList());
       
        }


       return listProductsDTO;
   
        
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
