package com.example.demo.DTO;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category productCategory = new Category();
        productCategory.setName(category);
        product.setCategory(productCategory);

        return product;
    }
}


