package com.example.backend.Repositories;

import com.example.backend.Model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageDAO extends JpaRepository<ProductImage, Integer> {
}
