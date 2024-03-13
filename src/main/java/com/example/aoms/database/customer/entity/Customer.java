package com.example.aoms.database.customer.entity;

import com.example.aoms.database.address.entity.Address;
import com.example.aoms.database.invoice.entity.Invoice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer", schema = "app")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nip", nullable = false, length = 10)
    private String nip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices = new LinkedHashSet<>();

}