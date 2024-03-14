package com.example.aoms.api.invoice_product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_invoice_product_type", schema = "app")
public class ProductInvoiceProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false, length = 256)
    private String type;

    @OneToMany(mappedBy = "productType")
    private Set<ProductInvoiceInfo> productInvoiceInfos = new LinkedHashSet<>();

}