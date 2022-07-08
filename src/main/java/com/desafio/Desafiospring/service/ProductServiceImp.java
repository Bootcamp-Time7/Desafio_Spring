package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements IproductService{

    @Autowired
    ProductRepo repo;
//
//    /**
//     *
//     * author: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
//     * Permite acesso ao método getProductAll do repositório, cria uma lista de produtos do tipo ProductRequestDTO e retorna essa lista
//     *
//     */

    @Override
    public List<ProductRequestDTO> getProductAll() {
        List<Product> listProducts = repo.getProductAll();
        List<ProductRequestDTO> listProductsDTO = listProducts.stream()
                .map(ProductRequestDTO::new).collect(Collectors.toList());
        return listProductsDTO;
    }


//    /**
//     *
//     * author: Yago
//     * Permite acesso ao método saveProducts do repositório
//     *
//     */

    @Override
    public List<ProductResponseDTO> saveProducts(List<Product> products) {

        return null;
    }

    @Override
    public List<CartRequestDTO> createShoppingCart(List<ProductResponseDTO> products) {
        return null;
    }

//    /**
//     *
//     * author: Mônica
//     * param: String category
//     * Permite acesso ao método getProductAll do repositório. Cria uma nova lista do tipo ProductRequestDTO. É feito um filtro por categoria de produtos,
//     * inseridos os objetos to tipo ProductRequestDTO e criada a lista final.
//     * return <ProductRequestDTO> listProductsDtoCategory
//     *
//     */

    @Override
    public List<ProductRequestDTO> getAllByCategory(String category) {
        if(category.equals("false")){
            throw new NotFoundException("Categoria não encontrada");
        }else {
            List<Product> listProducts = repo.getProductAll();
            List<ProductRequestDTO> listProductsDtoCategory = listProducts.stream()
                    .filter(productDto->productDto.getCategory().equalsIgnoreCase(category))
                    .map(ProductRequestDTO::new)
                    .collect(Collectors.toList());
            return listProductsDtoCategory;
        }


    }


    //TODO Criar uma classe generica para o filtro de dois produtos, criar uma exceçao para nao receber quantidade
    @Override
    public List<ProductRequestDTO> getAllByTwoFilters(String firstFilter, boolean secondFilter) {
        return null;
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
