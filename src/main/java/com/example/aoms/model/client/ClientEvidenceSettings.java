package com.example.aoms.model.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Table(name = "client_evidence_settings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// TODO SYSTEM BĘDZIE REALIZOWANY TYLKO DLA FIRM KTÓRYCH TYP EWIDENCJI TO KSIĘGA WIECZYSTA
public class ClientEvidenceSettings {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from", nullable = false)
    private Timestamp from;

    @Column(name = "kpir", nullable = false)
    private Integer KPiR;
}
