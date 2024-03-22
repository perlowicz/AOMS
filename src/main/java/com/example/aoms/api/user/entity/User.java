package com.example.aoms.api.user.entity;

import com.example.aoms.api.company.entity.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "user")
    private Set<Company> companies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<VerificationToken> verificationTokens = new LinkedHashSet<>();

}