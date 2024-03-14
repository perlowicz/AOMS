package com.example.aoms.api.invoice.service;

import com.example.aoms.api.company.entity.Company;
import com.example.aoms.api.company.service.CompanyService;
import com.example.aoms.api.customer.entity.Customer;
import com.example.aoms.api.customer.service.CustomerService;
import com.example.aoms.api.invoice.dto.InvoiceDto;
import com.example.aoms.api.invoice.entity.Invoice;
import com.example.aoms.api.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerService customerService;
    private final CompanyService companyService;


    @Override
    public List<InvoiceDto> findAllByUserId(Long userId) {
        //TODO zastanowić się jak ograć relację usera i company.
        return null;
    }

    @Override
    @Transactional
    public Invoice save(InvoiceDto dto) {
        Customer savedCustomer = customerService.save(dto.getCustomer());
        Company savedCompany = companyService.save(dto.getCompany());
        Invoice entity = mapDtoToEntity(dto, savedCustomer, savedCompany);
        return invoiceRepository.save(entity);
    }

    private Invoice mapDtoToEntity(InvoiceDto dto, Customer customer, Company company) {
        Invoice entity = new Invoice();
        entity.setNumber(dto.getNumber());
        entity.setDate(dto.getDate());
        entity.setTaxRate(dto.getTaxRate());
        entity.setNettoRate(dto.getNettoRate());
        entity.setBruttoRate(dto.getBruttoRate());
        entity.setOverallValue(dto.getOverallValue());
        entity.setCustomer(customer);
        entity.setCompany(company);
        return entity;
    }
}
