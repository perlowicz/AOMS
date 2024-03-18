package com.example.aoms.api.service_invoice.entity;

import com.example.aoms.api.invoice.entity.Invoice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

    @Column(name = "name", length = 256)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    @Column(name = "netto_price", nullable = false, precision = 6, scale = 2)
    private BigDecimal nettoPrice;

    @Column(name = "brutto_price", nullable = false, precision = 6, scale = 2)
    private BigDecimal bruttoPrice;

}