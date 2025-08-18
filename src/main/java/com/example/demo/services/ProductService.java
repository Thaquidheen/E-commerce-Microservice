package com.example.demo.services;

import com.example.demo.Exceptions.ProductNotExceptions;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotExceptions;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    Product updateProduct(Long id, Product product);
}
