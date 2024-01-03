package com.example.aoms.model.client;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "client_general_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientGeneralInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "nip", nullable = false)
    private Integer NIP;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "date_of_insertion", nullable = false)
    private Timestamp dateOfInsertion;

    @Column(name = "is_sole_proprietor", nullable = false)
    private Boolean isSoleProprietor;

    @Column(name = "is_company_active", nullable = false)
    private Boolean isCompanyActive;
}
