package com.example.backend.Repositories;

import com.example.backend.Model.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidTokenDAO extends JpaRepository<InvalidToken, String> {
}
