package com.example.aoms.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"", schema = "app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 256)
    private String userName;

    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "role", nullable = false, length = 256)
    private String role;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled = false;

}