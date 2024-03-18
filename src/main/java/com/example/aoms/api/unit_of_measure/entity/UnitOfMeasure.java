package com.example.aoms.api.unit_of_measure.entity;

import com.example.aoms.api.invoice_product.entity.ProductInvoiceInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "unit_of_measure", schema = "app")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "unit", nullable = false, length = 256)
    private String unit;

    @OneToMany(mappedBy = "unitOfMeasure")
    private Set<ProductInvoiceInfo> productInvoiceInfos = new LinkedHashSet<>();

}