package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //marks the interface as spring data jpa repo
public interface UsersRepo extends JpaRepository<Users, Long> {//provides CRUD operations automatically for User entity

    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    //Customer findFirstByEmail(String email);
}
