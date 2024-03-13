package com.example.aoms.invoice.service;

import com.example.aoms.company.entity.Company;
import com.example.aoms.company.service.CompanyService;
import com.example.aoms.customer.entity.Customer;
import com.example.aoms.customer.service.CustomerService;
import com.example.aoms.invoice.dto.InvoiceDto;
import com.example.aoms.invoice.entity.Invoice;
import com.example.aoms.invoice.repository.InvoiceRepository;
import com.example.aoms.invoice_product.entity.ProductInvoiceInfo;
import com.example.aoms.invoice_product.service.ProductInvoiceInfoService;
import com.example.aoms.invoice_service.entity.ServiceInvoiceInfo;
import com.example.aoms.invoice_service.service.ServiceInvoiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final ProductInvoiceInfoService productInvoiceInfoService;
    private final ServiceInvoiceInfoService serviceInvoiceInfoService;


    @Override
    @Transactional
    public void save(InvoiceDto dto) {
        Customer savedCustomer = customerService.save(dto.getCustomer());
        Company savedCompany = companyService.save(dto.getCompany());
        ProductInvoiceInfo savedProductInfo = productInvoiceInfoService.save(dto.getProductInvoiceInfo());
        ServiceInvoiceInfo savedServiceInfo = serviceInvoiceInfoService.save(dto.getServiceInvoiceInfo());

        Invoice entity = mapDtoToEntity(dto, savedCustomer, savedCompany, savedProductInfo, savedServiceInfo);
        invoiceRepository.save(entity);
    }

    private Invoice mapDtoToEntity(InvoiceDto dto, Customer customer, Company company,
                                   ProductInvoiceInfo productInvoiceInfo, ServiceInvoiceInfo serviceInvoiceInfo) {
        Invoice entity = new Invoice();
        entity.setNumber(dto.getNumber());
        entity.setDate(dto.getDate());
        entity.setTaxRate(dto.getTaxRate());
        entity.setNettoRate(dto.getNettoRate());
        entity.setBruttoRate(dto.getBruttoRate());
        entity.setOverallValue(dto.getOverallValue());
        entity.setCustomer(customer);
        entity.setCompany(company);
        entity.setProductInvoiceInfo(productInvoiceInfo);
        entity.setServiceInvoiceInfo(serviceInvoiceInfo);
        return entity;
    }
}
