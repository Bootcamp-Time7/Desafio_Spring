package com.desafio.Desafiospring.controller;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.service.IproductService;
import com.desafio.exception.*;
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
     * author:  Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     * @return
     * @throws HandlerException
     */

    @GetMapping("")

    public ResponseEntity<List<ProductRequestDTO>> getProductAll() throws HandlerException {
            List<ProductRequestDTO> list =  service.getProductAll();
            return ResponseEntity.ok(list);
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
            List<ProductRequestDTO> list = service.getAllByAlphabetic(category, freeShipping, order);
            return ResponseEntity.ok(list);
    }

    /**
     * author: Amanda
     * @param category
     * @param freeShipping
     * @param prestige
     * @return
     */
    @GetMapping("/search")
    @ExceptionHandler({ NotFoundException.class})
    public ResponseEntity<List<ProductRequestDTO>> getAllByTwoFilters(
            @RequestParam("category") Optional<String> category,
            @RequestParam("freeShipping") boolean freeShipping,
            @RequestParam("prestige") Optional<String> prestige) {
            this.category = category;
            this.prestige = prestige;
            return ResponseEntity.ok().body(service.getAllByFilters(category, freeShipping, prestige));
    }

    /**
     * author: Yago
     * @param products
     */
    @PostMapping("/insert-articles-request")
    @ExceptionHandler({ CreateException.class})
    public void saveProductsVoid(@RequestBody List<Product> products){
            service.saveProductsVoid(products);
    }


    /**
     * author: Monica
     * @param category
     * @return
     */
    @GetMapping("/category")
    public ResponseEntity<List<ProductRequestDTO>> getAllByCategory (@RequestParam String category) {

            List<ProductRequestDTO> listProductByCategory = service.getAllByCategory(category);
            return ResponseEntity.ok(listProductByCategory);

    }

    /**
     * author: Gabriel
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */
    @GetMapping("/order/decrescent")
    public ResponseEntity<List<ProductRequestDTO>> getAllByHigherPrice (@RequestParam String category, @RequestParam boolean freeShipping, @RequestParam int order) {
        List<ProductRequestDTO> listProductAllByHigherPrice = service.getAllByHigherPrice(category, freeShipping, order);
        return ResponseEntity.ok(listProductAllByHigherPrice);
    }

    /**
     *
     * @param category
     * @param freeShipping
     * @param order
     * @return
     */
    @GetMapping("/order/crescent")
    public ResponseEntity<List<ProductRequestDTO>> getAllByLowerPrice (@RequestParam String category, @RequestParam boolean freeShipping, @RequestParam int order) {
        List<ProductRequestDTO> listProductAllLowerPrice = service.getAllByLowerPrice(category, freeShipping, order);
        return ResponseEntity.ok(listProductAllLowerPrice);
    }

}
