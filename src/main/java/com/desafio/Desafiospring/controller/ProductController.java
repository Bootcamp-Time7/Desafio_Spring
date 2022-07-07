package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.Desafiospring.service.IproductService;
import com.desafio.Desafiospring.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private IproductService service;


    /**
     *
     * @authors: Amanda, Gabryel, Marina, Mônica, Nicole, Yago
     * @route: articles
     * Devolve para o viewer a lista de todos os produtos, a partir do chamamento do método construído na camada service
     * @return: Lista do tipo ProductRequestDTO
     */

    @GetMapping("/articles")
    public ResponseEntity<List<ProductRequestDTO>> getProductAll(){
        List<ProductRequestDTO> list =  service.getProductAll();
        return ResponseEntity.ok(list);
    }


    /**
     *
     * @authors: Mônica
     * @route: articles/category
     * Devolve para o viewer a lista dos produtos filtrada por categoria, a partir do chamamento do método construído na camada service.
     * O usuário poderá selecionar a categoria de produtos desejada e visualizará uma lista de produtos para aquela categoria.
     * @return: Lista filtrada por categoria, do tipo ProductRequestDTO
     */

    @GetMapping("/articles/category")
    public ResponseEntity<List<ProductRequestDTO>> getAllByCategory (@RequestParam String category) {
        List<ProductRequestDTO> listProductByCategory = service.getAllByCategory(category);
        return ResponseEntity.ok(listProductByCategory);

    }



}
