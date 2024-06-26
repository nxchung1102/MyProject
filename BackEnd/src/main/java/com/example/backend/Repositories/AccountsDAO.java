package com.example.backend.Repositories;

import com.example.backend.Model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsDAO extends JpaRepository<Accounts, String> {
    Boolean existsAccountsByEmail(String Email);

    Optional<Accounts> findByEmail(String Email);
}
