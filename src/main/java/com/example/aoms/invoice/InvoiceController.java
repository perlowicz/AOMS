package com.example.aoms.invoice;

import com.example.aoms.invoice_service.dto.ServiceInvoiceInfoDto;
import com.example.aoms.invoice_service.service.ServiceInvoiceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final ServiceInvoiceInfoService serviceInvoiceInfoService;


//    @GetMapping("/invoices/{companyId}")
//    ResponseEntity<?> getInvoicesByCompany(@PathVariable Long companyId) {
//        return ResponseEntity.ok(invoiceService.getInvoicesByCompany(companyId));
//    }

    @GetMapping("/service")
    ResponseEntity<?> getService() {
        return ResponseEntity.ok("Test service get response");
    }

    @PostMapping("/service")
    ResponseEntity<?> saveInvoiceService(@RequestBody ServiceInvoiceInfoDto dto) {
        ServiceInvoiceInfoDto savedDto = serviceInvoiceInfoService.save(dto);
        return ResponseEntity
                .status(201)
                .body(savedDto);
    }

    @PostMapping("/info")
    ResponseEntity<?> infoPostMethod(@RequestBody String message) {
        return ResponseEntity.ok("Info post answer: " + message);
    }


    @PostMapping("/invoices")
    ResponseEntity<?> saveInvoice(@RequestBody InvoiceFormDto dto) {
        Long savedEntityId = invoiceService.save(dto);
        return ResponseEntity
                .status(201)
                .body("Saved invoice with id: " + savedEntityId);
    }
}
