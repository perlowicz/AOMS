package com.example.aoms.model.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "vat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VAT {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @ManyToMany(mappedBy = "vats")
    private Set<Client> clients = new HashSet<>();
}
