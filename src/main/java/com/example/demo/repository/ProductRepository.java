package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



//HQL
    @Query("Select p.id ,p.title from Product p")
    List<ProductWithIdAndTitle> randomSearchMethodForProduct();
}
