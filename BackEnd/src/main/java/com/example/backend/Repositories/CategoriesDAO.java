package com.example.backend.Repositories;

import com.example.backend.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO extends JpaRepository<Categories, Integer> {
}
