package com.example.aoms.api.entity;

import com.example.aoms.api.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "company", schema = "app")
public class Company {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "nip", nullable = false, length = 10)
    private String nip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "company")
    private Set<Invoice> invoices = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}