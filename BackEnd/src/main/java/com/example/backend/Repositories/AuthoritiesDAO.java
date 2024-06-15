package com.example.backend.Repositories;

import com.example.backend.Model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthoritiesDAO extends JpaRepository<Authorities, Integer> {
    @Query(value = "select * from Authorities where Username like :username", nativeQuery = true)
    Optional<Authorities> getUserByUserName(@Param("username") String username);
}
