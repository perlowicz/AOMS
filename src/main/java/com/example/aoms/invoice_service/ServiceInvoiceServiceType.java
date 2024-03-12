package com.example.aoms.invoice_service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "service_invoice_service_type", schema = "app")
public class ServiceInvoiceServiceType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false, length = 256)
    private String type;

    @OneToMany(mappedBy = "serviceType")
    private Set<ServiceInvoiceInfo> serviceInvoiceInfos = new LinkedHashSet<>();

}