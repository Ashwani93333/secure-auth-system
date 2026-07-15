package com.secure_backend.auth_app.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    //Custom Query
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
