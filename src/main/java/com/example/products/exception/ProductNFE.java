package com.example.products.exception;

public class ProductNFE extends RuntimeException {

    public ProductNFE(Long id) {
        super("Producto no encontrado con id: " + id);
    }
}