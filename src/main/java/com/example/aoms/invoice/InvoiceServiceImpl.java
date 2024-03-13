package com.example.aoms.invoice;

import com.example.aoms.address.AddressDto;
import com.example.aoms.address.AddressService;
import com.example.aoms.company.CompanyDto;
import com.example.aoms.company.CompanyService;
import com.example.aoms.country.Country;
import com.example.aoms.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.aoms.invoice.InvoiceMapper.mapDtoToEntity;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CountryService countryService;
    private final AddressService addressService;
    private final CompanyService companyService;
    private final CustomerService customerService;


    @Override
    @Transactional
    public Long save(InvoiceFormDto dto) {

        Country companySavedCountry = countryService.save(dto.getCompanyDto().getAddressDto().getCountry());
        Country customerSavedCountry = countryService.save(dto.getCustomerDto().getAddressDto().getCountry());

        AddressDto companyAddressSaved = addressService.save(dto.getCompanyDto().getAddressDto());
        AddressDto customerAddressSaved = addressService.save(dto.getCustomerDto().getAddressDto());

        CompanyDto savedCompany = companyService.save(dto.getCompanyDto());
        CustomerDto savedCustomer = customerService.save(dto.getCustomerDto());


        Invoice entity = mapDtoToEntity(dto);
        Invoice savedInvoice = invoiceRepository.save(entity);
        return savedInvoice.getId();
    }
}
