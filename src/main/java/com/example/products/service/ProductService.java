package com.example.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.entity.Product;
import com.example.products.exception.ProductNFE;
import com.example.products.repository.ProductRepository;

@Service
public class ProductService {
    
    //Here "conection" with the repository
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Find all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //Search a product by id, if not found, throw an exception
    public Product findById(long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new ProductNFE(id));
    }

    //Save a new product
    //But first validate the price don´t be elderly than 10,000
    public Product save(Product product) {
        if (product.getPrice() > 10000) {
            throw new IllegalArgumentException("El precio no puede ser mayor a 10000");
        }
        return productRepository.save(product);
    }

    //Filter products by max price
    public List<Product> findByMaxPrice(Double maxPrice) {
        return productRepository.findByPriceLessThan(maxPrice);
    }
}