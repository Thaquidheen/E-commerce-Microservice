package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base {
    private String title;
    private Double price;
    private String description;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
