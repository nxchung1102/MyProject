package com.example.backend.Repositories;

import com.example.backend.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Integer> {
}
