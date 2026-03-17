package com.example.products.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.entity.Product;
import com.example.products.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    //Here "conection" with the service
    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    //Get all products /products
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    //Get filter products by max price /products/filter?maxPrice=1000
    @GetMapping ("/filter")
    public ResponseEntity<List<Product>> findByMaxPrice(@RequestParam Double maxPrice) {
        return ResponseEntity.ok(productService.findByMaxPrice(maxPrice));
    }

    //Get a product by id /products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    //Post a new product /products
    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
}
