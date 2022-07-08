package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.dto.ProductResponseDTO;
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

    @PostMapping("/add")
    public ResponseEntity<List<ProductResponseDTO>> saveProductsVoid(@RequestBody List<Product> productsList){
        service.saveProductsVoid(productsList);
        List<ProductResponseDTO> productResponseDTOList = ProductResponseDTO.convertForListProdRespDTO(productsList);
        return ResponseEntity.ok(productResponseDTOList);

    }

}
