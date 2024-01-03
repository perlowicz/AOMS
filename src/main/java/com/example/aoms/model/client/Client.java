package com.example.aoms.model.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_general_info_id", referencedColumnName = "id")
    private ClientGeneralInfo clientGeneralInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_address_info_id", referencedColumnName = "id")
    private ClientAddressInfo clientAddressInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_shares_id", referencedColumnName = "id")
    private ClientShares clientShares;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_evidence_settings_id", referencedColumnName = "id")
    private ClientEvidenceSettings clientEvidence;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "client_vat",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "vat_id"))
    private Set<VAT> vats;
}
