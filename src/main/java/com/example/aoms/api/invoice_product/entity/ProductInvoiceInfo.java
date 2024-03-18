package com.example.aoms.api.invoice_product.entity;

import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.unit_of_measure.entity.UnitOfMeasure;
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

}