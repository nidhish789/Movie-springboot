package com.example.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.model.ProductModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer>{
    
}
