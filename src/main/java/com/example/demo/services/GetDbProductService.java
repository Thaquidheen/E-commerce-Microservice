package com.example.demo.services;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public class GetDbProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long id){
        return null;
    }

    @Override
    public List<Product> getAllProducts(){
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
