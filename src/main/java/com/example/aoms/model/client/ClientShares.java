package com.example.aoms.model.client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "client_shares")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientShares {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from_date", nullable = false)
    private Timestamp fromDate;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "percentage_of_shares", nullable = false)
    private Double percentageOfShares;
}
