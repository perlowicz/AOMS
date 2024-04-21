package com.example.aoms.api.service;

import com.example.aoms.api.entity.Company;
import com.example.aoms.api.exception.CompanyNotFoundException;
import com.example.aoms.api.mapper.CompanyMapper;
import com.example.aoms.api.entity.Customer;
import com.example.aoms.api.mapper.CustomerMapper;
import com.example.aoms.api.dto.InvoiceDto;
import com.example.aoms.api.entity.Invoice;
import com.example.aoms.api.repository.InvoiceRepository;
import com.example.aoms.api.jwt_token.service.JwtService;
import com.example.aoms.api.entity.user.User;
import com.example.aoms.api.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final JwtService jwtService;
    private final UserService userService;


    @Override
    public List<InvoiceDto> getAllForUserWithJwt(String jwt) {
        Long userId = jwtService.extractUserId(jwt);
        User user = userService.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %s not found", userId)));
        Company company = companyService.findCompanyById(user.getCompany().getId())
                .orElseThrow(() -> new CompanyNotFoundException(String.format("Company for user with id: %s not found", userId)));

        return invoiceRepository.findAllByCompany(company)
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Invoice save(InvoiceDto dto, String jwt) {
        Customer savedCustomer = customerService.save(dto.getCustomer());
        Company savedCompany = companyService.save(dto.getCompany(), jwt);
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

    private InvoiceDto mapEntityToDto(Invoice entity) {
        return InvoiceDto.builder()
                .number(entity.getNumber())
                .date(entity.getDate())
                .taxRate(entity.getTaxRate())
                .nettoRate(entity.getNettoRate())
                .bruttoRate(entity.getBruttoRate())
                .overallValue(entity.getOverallValue())
                .customer(CustomerMapper.mapEntityToDto(entity.getCustomer()))
                .company(CompanyMapper.mapEntityToDto(entity.getCompany()))
                .build();
    }
}
