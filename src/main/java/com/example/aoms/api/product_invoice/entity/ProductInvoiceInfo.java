package com.example.aoms.api.product_invoice.entity;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
import com.example.aoms.api.vat_rate.entity.VatRate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product_invoice_info", schema = "app")
public class ProductInvoiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unit_of_measure_id", nullable = false, referencedColumnName = "id")
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "netto_value", nullable = false, precision = 6, scale = 2)
    private BigDecimal nettoValue;

    @Column(name = "brutto_value", nullable = false, precision = 6, scale = 2)
    private BigDecimal bruttoValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vat_rate_id", nullable = false)
    private VatRate vatRate;

    @Column(name = "vat_value", nullable = false, precision = 6, scale = 2)
    private BigDecimal vatValue;

}