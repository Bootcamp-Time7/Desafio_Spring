package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.model.Product;
import com.desafio.Desafiospring.repository.ProductRepo;
import com.desafio.Desafiospring.service.IproductService;
import com.desafio.Desafiospring.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/alphabetic/{category}/{freeShipping}/{order}")
    public ResponseEntity<List<ProductRequestDTO>> getAllByAlphabetic(@PathVariable String category, boolean freeShipping, int order) {
       List<ProductRequestDTO> list = service.getAllByAlphabetic(category, freeShipping, order);
       return ResponseEntity.ok(list);
    }
}
