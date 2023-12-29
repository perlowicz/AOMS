package com.example.aoms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private String invoiceNumber;
    private String sellerName;
    private String sellerAdress;
    private String sellerNIP;
    private String sellerPhoneNumber;
    private String sellerEmailAdress;
    private String buyerName;
    private String buyerAdress;
    private String buyerNIP;
    private String buyerPhoneNumber;
    private String buyerEmailAdress;
    private PaymentType paymentType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceItem> invoiceItemList;
    private Double totalNettoValue;
    private Double totalBruttoValue;
    private String comment;
}
