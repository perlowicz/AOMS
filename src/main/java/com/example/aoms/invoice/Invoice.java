package com.example.aoms.invoice;

import com.example.aoms.Company;
import com.example.aoms.Customer;
import com.example.aoms.ProductInvoiceInfo;
import com.example.aoms.ServiceInvoiceInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "invoice", schema = "app")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_invoice_info_id")
    private ServiceInvoiceInfo serviceInvoiceInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_invoice_info_id")
    private ProductInvoiceInfo productInvoiceInfo;

    @Column(name = "number", nullable = false, length = 256)
    private String number;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "tax_rate", nullable = false, precision = 4, scale = 1)
    private BigDecimal taxRate;

    @Column(name = "netto_rate", nullable = false, precision = 6, scale = 2)
    private BigDecimal nettoRate;

    @Column(name = "brutto_rate", nullable = false, precision = 6, scale = 2)
    private BigDecimal bruttoRate;

    @Column(name = "overall_value", nullable = false, precision = 6, scale = 2)
    private BigDecimal overallValue;

}