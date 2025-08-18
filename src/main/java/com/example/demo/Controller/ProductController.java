package com.example.demo.Controller;


import com.example.demo.Exceptions.ProductNotExceptions;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("DbProductService") ProductService productService){
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
    public ResponseEntity<List<Product>> getAllProducts(){

        ResponseEntity<List<Product>> response= new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
        return response;

    }


//    delete product
@DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id")Long product_Id) throws ProductNotExceptions {
         productService.deleteSingleproduct(product_Id);
    }
    // FIXED: Replace entire product (PUT)
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);  // ✅ Pass both parameters
    }

    // FIXED: Update partial product (PATCH)
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)throws ProductNotExceptions{
        return productService.updateProduct(id, product);   // ✅ Pass both parameters
    }
}
