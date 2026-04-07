package com.example.hibernatedemo;

import jakarta.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "user_name")
//    private String username;
//
//    @Column(name = "email")
//    private String email;
//
//    public User() {
//    }
//
//    public User(String username, String email) {
//        this.username = username;
//        this.email = email;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "User [id=" + id + ", username=" + username + ", email=" + email + "]";
//    }
//}

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY is generally preferred for MySQL/PostgreSQL
    private int id;

    @Column(name = "user_name", length = 50, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    // 1. @Lob: For large data like a biography or profile description
    @Lob
    private String bio;

    // 2. @Enumerated: To store Enums as Strings (standard) instead of integers
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // 3. @Temporal: Maps Java Date to SQL Timestamp/Date
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    // 4. @Version: Enables Optimistic Locking (prevents data overwrite issues)
    @Version
    private int version;

    @Transient // Will not be persisted in the DB
    private int age;

    // Standard Constructor
    public User() {
        this.createdAt = new Date();
    }

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { // Fixed: added parameter
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }

    public void setBio(String bio) { this.bio = bio; }

    public UserRole getRole() { return role; }

    public void setRole(UserRole role) { this.role = role; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}

enum UserRole {
    ADMIN, USER, GUEST
}