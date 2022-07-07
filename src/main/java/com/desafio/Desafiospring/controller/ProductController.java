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

    @GetMapping("/articles")
    public ResponseEntity<List<ProductRequestDTO>> getProductAll(){
        List<ProductRequestDTO> list =  service.getProductAll();
        return ResponseEntity.ok(list);
    }
    /**
     * @author Nicole Calderari
     * Esta é uma rota get, nela foi colocado um fragmento a mais na url "/alphabet" porque estava dando conflito
     * com a rota genérica de todos os produtos.
     * Esse método requisita os parâmetros da url e os passa para a função getAllByAlphabetic que faz a ordenação.
     * Retorna status 200 e a lista dos produtos filtrados de acordo com os parâmetros.
     */
    @GetMapping("/articles/alphabet")
    public ResponseEntity<List<ProductRequestDTO>> getAllByAlphabetic(
        @RequestParam String category, 
        @RequestParam  boolean freeShipping, 
        @RequestParam  int order) {
       List<ProductRequestDTO> list = service.getAllByAlphabetic(category, freeShipping, order);
       return ResponseEntity.ok(list);
    }
}
