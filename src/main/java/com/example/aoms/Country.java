package com.example.aoms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "country", schema = "app")
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country", nullable = false, length = 256)
    private String country;

}