package com.example.aoms.invoice_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "service_invoice_info", schema = "app")
public class ServiceInvoiceInfo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scope", nullable = false, length = 256)
    private String scope;

    @Column(name = "date")
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceInvoiceServiceType serviceType;

    @Column(name = "name", length = 256)
    private String name;

}