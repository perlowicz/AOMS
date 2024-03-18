package com.example.aoms.api.invoice.service;

import com.example.aoms.api.invoice.dto.InvoiceDto;
import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.product_invoice.service.ProductInvoiceInfoService;
import com.example.aoms.api.service_invoice.service.ServiceInvoiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SavingInvoiceServiceImpl implements SavingInvoiceService {

    private final InvoiceService invoiceService;
    private final ProductInvoiceInfoService productInvoiceInfoService;
    private final ServiceInvoiceInfoService serviceInvoiceInfoService;


    @Override
    @Transactional
    public void save(InvoiceDto dto) {
        Invoice invoice = invoiceService.save(dto);
        productInvoiceInfoService.saveAll(dto.getListOfProductInvoiceInfo(), invoice);
        serviceInvoiceInfoService.saveAll(dto.getListOfServiceInvoiceInfo(), invoice);
    }
}
