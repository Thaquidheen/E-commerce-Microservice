//package com.example.demo.services;
//import com.example.demo.DTO.FakeProductDto;
//import com.example.demo.Exceptions.ProductNotExceptions;
//import com.example.demo.model.Product;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
////@Service("FakeProductService")
//public class FakeStoreProductService implements ProductService{
//
//    RestTemplate restTemplate;
//
//    public FakeStoreProductService(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }
//
//
////get single product service
//    @Override
//    public Product getSingleProduct(Long productId) throws ProductNotExceptions {
//        FakeProductDto fakeStoreProduct = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/" + productId,
//                FakeProductDto.class);
//        if(fakeStoreProduct == null){
//             throw new ProductNotExceptions("Product with id" + productId + "does not exist");
//        }
//        return fakeStoreProduct.toProduct();
//    }
//
//
////    get all product services
//    @Override
//     public List<Product> getAllProducts(){
//        FakeProductDto[] products =  restTemplate.getForObject(
//                "https://fakestoreapi.com/products", FakeProductDto[].class);
//        assert products != null;
//
//        return Arrays.stream(products)
//                .map(FakeProductDto::toProduct)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Product deleteSingleproduct(Long product_Id) {
//        return null;
//    }
//
//    @Override
//    public Product replaceProduct(Long id, Product product) {
//        // Convert our Product to FakeProductDto
//        FakeProductDto requestDto = convertToFakeProductDto(product);
//
//        // Make PUT request to external API
//        FakeProductDto updatedProduct = restTemplate.exchange(
//                "https://fakestoreapi.com/products/" + id,
//                HttpMethod.PUT,
//                new HttpEntity<>(requestDto),
//                FakeProductDto.class
//        ).getBody();
//
//        assert updatedProduct != null;
//        return updatedProduct.toProduct();
//    }
//
//
//    // FIXED: Update partial product (PATCH)
//    @Override
//    public Product updateProduct(Long id, Product product) {
//        // Convert our Product to FakeProductDto
//        FakeProductDto requestDto = convertToFakeProductDto(product);
//
//        // Make PATCH request to external API
//        FakeProductDto updatedProduct = restTemplate.exchange(
//                "https://fakestoreapi.com/products/" + id,
//                HttpMethod.PATCH,
//                new HttpEntity<>(requestDto),
//                FakeProductDto.class
//        ).getBody();
//
//        assert updatedProduct != null;
//        return updatedProduct.toProduct();
//    }
//
//    // Helper method: Convert Product to FakeProductDto
//    private FakeProductDto convertToFakeProductDto(Product product) {
//        FakeProductDto dto = new FakeProductDto();
//        dto.setId(product.getId());
//        dto.setTitle(product.getTitle());
//        dto.setPrice(product.getPrice());
//        dto.setDescription(product.getDescription());
//        dto.setImage(product.getImageUrl());
//
//        if (product.getCategory() != null) {
//            dto.setCategory(product.getCategory().getName());
//        }
//
//        return dto;
//    }
//}
