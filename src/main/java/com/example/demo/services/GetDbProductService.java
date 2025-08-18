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
    public void deleteSingleproduct(Long product_Id) throws ProductNotExceptions{
        Optional<Product> productoptional = productRepository.findById(product_Id);

        if(productoptional.isEmpty()){
            throw new ProductNotExceptions("product with id not present");
        }
    productRepository.deleteById(product_Id);
    }

    @Override
    public List<Product> getAllProducts(){
          return productRepository.findAll();
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotExceptions{
        Optional<Product> productoptional = productRepository.findById(id);

        if(productoptional.isEmpty()){
            throw new ProductNotExceptions("product with id not present");
        }
        Product getDbProduct = productoptional.get();

        if(product.getTitle() != null){
            getDbProduct.setTitle(product.getTitle());
        }

        if(product.getPrice() != null){
            getDbProduct.setPrice(product.getPrice());
        }
        return productRepository.save(getDbProduct);
    }
}
