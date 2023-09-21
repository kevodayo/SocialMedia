package com.project.userservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private BigDecimal code;
    private String username;
    private String email;
    private String password; // Hashed and salted password
    private String fullName;
}
