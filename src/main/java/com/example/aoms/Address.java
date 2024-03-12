package com.example.aoms;

import com.example.aoms.country.Country;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "app")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "city", nullable = false, length = 256)
    private String city;

    @Column(name = "street_name", nullable = false, length = 256)
    private String streetName;

    @Column(name = "street_number", nullable = false)
    private Integer streetNumber;

}