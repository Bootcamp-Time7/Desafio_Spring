package com.desafio.Desafiospring.service;

import com.desafio.Desafiospring.dto.CartRequestDTO;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.exception.NotFoundExceptions;
import com.desafio.handler.HandlerExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
            throw new NotFoundExceptions("Categoria não encontrada");
        }else {
            List<Product> listProducts = repo.getProductAll();
            List<ProductRequestDTO> listProductsDtoCategory = listProducts.stream()
                    .filter(productDto->productDto.getCategory().equalsIgnoreCase(category))
                    .map(ProductRequestDTO::new)
                    .collect(Collectors.toList());
            return listProductsDtoCategory;
        }


    }

    /**
     *author:Amanda
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
     *author:Amanda
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

    /**
     *author:Amanda
     * @param list
     * @param prestige
     * @param freeShipping
     * @return
     */
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

    /**
     * author: Nicole Calderari
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
