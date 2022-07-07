package com.desafio.Desafiospring.controller;

import com.desafio.Desafiospring.dto.ProductRequestDTO;
import com.desafio.Desafiospring.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public ResponseEntity<List<ProductRequestDTO>> getProductAll(){
        List<ProductRequestDTO> list =  service.getProductAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductRequestDTO>> getAllByTwoFilters(
            @RequestParam("category") Optional<String> category,
            @RequestParam("freeShipping") Optional<Boolean> freeShipping,
            @RequestParam("prestige") Optional<String> prestige) {
        this.category = category;
        this.freeShipping = freeShipping;
        this.prestige = prestige;


        return ResponseEntity.ok().body(service.getAllByFilters(category, freeShipping, prestige));
    }


}
