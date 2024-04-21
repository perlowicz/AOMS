package com.example.aoms.api.service;

import com.example.aoms.api.dto.InvoiceDto;
import com.example.aoms.api.entity.Invoice;
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
    public void save(InvoiceDto dto, String jwt) {
        Invoice invoice = invoiceService.save(dto, jwt);
        productInvoiceInfoService.saveAll(dto.getListOfProductInvoiceInfo(), invoice);
        serviceInvoiceInfoService.saveAll(dto.getListOfServiceInvoiceInfo(), invoice);
    }
}
