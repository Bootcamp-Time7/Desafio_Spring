package com.desafio.Desafiospring.controller;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.service.IproductService;
import com.desafio.exception.CreateException;
import com.desafio.exception.ErrorCallListException;
import com.desafio.handler.HandlerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class ProductController {

    @Autowired
    private IproductService service;
    private Optional<String> category;
    private Optional<Boolean> freeShipping;
    private Optional<String> prestige;



    /**
     *
     * authors: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     * route: articles
     * Devolve para o viewer a lista de todos os produtos, a partir do chamamento do método construído na camada service
     * return: Lista do tipo ProductRequestDTO
     */

    @GetMapping("")

    public ResponseEntity<List<ProductRequestDTO>> getProductAll() throws HandlerException {
        try {
            List<ProductRequestDTO> list =  service.getProductAll();
            return ResponseEntity.ok(list);
        }catch (Exception e){
            throw new ErrorCallListException();
        }

    }


    /**
     * author Nicole Calderari
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */
    @GetMapping("/alphabet")
    public ResponseEntity<List<ProductRequestDTO>> getAllByAlphabetic(@RequestParam String category, @RequestParam  boolean freeShipping, @RequestParam  int order) {
        try {
            List<ProductRequestDTO> list = service.getAllByAlphabetic(category, freeShipping, order);
            return ResponseEntity.ok(list);
        }catch (Exception e){
            throw new ErrorCallListException();
        }

    }

    /**
     * author: Amanda
     * @param category
     * @param freeShipping
     * @param prestige
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<List<ProductRequestDTO>> getAllByTwoFilters(
            @RequestParam("category") Optional<String> category,
            @RequestParam("freeShipping") boolean freeShipping,
            @RequestParam("prestige") Optional<String> prestige) {
        try {
            this.category = category;
            this.prestige = prestige;

            return ResponseEntity.ok().body(service.getAllByFilters(category, freeShipping, prestige));
        }catch (Exception e ){
            throw new ErrorCallListException();
        }

    }

    /**
     *author: Yago
     * @param products
     */
    @PostMapping("/insert-articles-request")
    public void saveProductsVoid(@RequestBody List<Product> products){
        try {
            service.saveProductsVoid(products);

        }catch (Exception e){
            throw new CreateException();
        }

    }


    /**
     *
     * authors: Mônica
     * route: articles/category
     * Devolve para o viewer a lista dos produtos filtrada por categoria, a partir do chamamento do método construído na camada service.
     * O usuário poderá selecionar a categoria de produtos desejada e visualizará uma lista de produtos para aquela categoria.
     * return: Lista filtrada por categoria, do tipo ProductRequestDTO
     */

    @GetMapping("/category")
    public ResponseEntity<List<ProductRequestDTO>> getAllByCategory (@RequestParam String category) {
        try {
            List<ProductRequestDTO> listProductByCategory = service.getAllByCategory(category);
            return ResponseEntity.ok(listProductByCategory);
        }catch (Exception e){
            throw new ErrorCallListException();
        }
    }




}
