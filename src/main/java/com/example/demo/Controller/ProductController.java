package com.example.demo.Controller;


import com.example.demo.Exceptions.ProductNotExceptions;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

//    get one product
    @GetMapping("/{id}")
    public ResponseEntity<Product>  getProductId(@PathVariable("id") Long id) throws ProductNotExceptions {
ResponseEntity<Product> response= new ResponseEntity<>(
        productService.getSingleProduct(id),
        HttpStatus.OK
);
        return response;
    }
//    Get all products
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // FIXED: Replace entire product (PUT)
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);  // ✅ Pass both parameters
    }

    // FIXED: Update partial product (PATCH)
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);   // ✅ Pass both parameters
    }
}
