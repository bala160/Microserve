package com.example.product.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class UserPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indicate AUTO_INCREMENT from the DB
    private int id;

    @Column(name = "username", nullable = false) // Ensure this maps to the correct column
    private String username;

    @Column(name = "password", nullable = false) // Ensure this maps to the correct column
    private String password;

    public UserPojo(int id, String name, String password) {
        this.id = id;
        this.username = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Add a no-arg constructor (public or protected)
    public UserPojo() {}

}
