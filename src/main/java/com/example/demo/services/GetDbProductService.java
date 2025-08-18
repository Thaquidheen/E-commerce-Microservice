package com.example.demo.services;

import com.example.demo.Exceptions.ProductNotExceptions;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DbProductService")
public class GetDbProductService implements ProductService{

     ProductRepository productRepository;

    public GetDbProductService(ProductRepository productRepository  ) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotExceptions{
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotExceptions("product with id not present");
        }

        return  optionalProduct.get();
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
