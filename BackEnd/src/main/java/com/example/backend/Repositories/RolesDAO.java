package com.example.backend.Repositories;

import com.example.backend.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends JpaRepository<Roles, String> {
}
