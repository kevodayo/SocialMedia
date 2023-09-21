package com.project.userservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private BigDecimal code;
    private String username;
    private String email;
    private String password; // Hashed and salted password
    private String fullName;
}
