package com.example.aoms.api.vat_rate.entity;

import com.example.aoms.api.product_invoice.entity.ProductInvoiceInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vat_rate", schema = "app")
public class VatRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rate", nullable = false, precision = 6, scale = 2)
    private BigDecimal rate;

    @OneToMany(mappedBy = "vatRate")
    private Set<ProductInvoiceInfo> productInvoiceInfos = new LinkedHashSet<>();

}