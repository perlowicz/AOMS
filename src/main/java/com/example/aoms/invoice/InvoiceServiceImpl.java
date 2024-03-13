package com.example.aoms.invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.aoms.invoice.InvoiceMapper.mapDtoToEntity;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;


    @Override
    @Transactional
    public Long save(InvoiceFormDto dto) {


        Invoice entity = mapDtoToEntity(dto);
        Invoice savedInvoice = invoiceRepository.save(entity);
        return savedInvoice.getId();
    }
}
