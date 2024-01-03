package com.example.aoms.model.client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "client_address_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//TODO rozbić logikę na możliwość rozgraniczenia adresów na adresy działalności / siedziby / korespondencji
public class ClientAddressInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from", nullable = false)
    private Timestamp from;

    @Column(name = "to", nullable = false)
    private Timestamp to;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;

}
