package com.project.userservice.Utils;

import java.security.SecureRandom;
import java.util.Base64;

public class HelperUtil {
    // Hash and salt the password using a secure hashing algorithm (e.g., BCrypt)
//    private String hashAndSaltPassword(String password) {
//        // Generate a salt
//        String salt = generateSalt();
//
//        // Hash the password with the salt
//        String hashedPassword = hashPasswordWithSalt(password, salt);
//
//        // Return the hashed and salted password
//        return hashedPassword;
//    }
    // Generate a random salt
    private String generateSalt() {
        // You can use a secure random number generator to create a unique salt
        // Here's an example using Java's SecureRandom:
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16 bytes is a good default size
        random.nextBytes(saltBytes);

        // Encode the salt as a Base64 string to store it in the database
        String salt = Base64.getEncoder().encodeToString(saltBytes);

        return salt;
    }

    // Hash the password with the provided salt using a secure hashing algorithm (BCrypt)
//    private String hashPasswordWithSalt(String password, String salt) {
//        // Combine the password and salt and hash them using BCrypt
//        String combinedPassword = salt + password;
//        String hashedPassword = passwordEncoder.encode(combinedPassword);
//
//        return hashedPassword;
//    }
}
