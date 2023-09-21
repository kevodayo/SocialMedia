package com.project.userservice.Repository;

import com.project.userservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigDecimal> {
    boolean existsByUsername(String userName);
    boolean existsByEmail(String email);
}
