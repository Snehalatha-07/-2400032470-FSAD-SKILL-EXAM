package com.klef.fsad.exam.controller;

import com.klef.fsad.exam.model.Invoice;
import com.klef.fsad.exam.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // POST - Add Invoice
    // URL: POST http://localhost:8080/invoice/add
    @PostMapping("/add")
    public ResponseEntity<String> addInvoice(@RequestBody Invoice invoice) {
        try {
            String response = invoiceService.addInvoice(invoice);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding invoice: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - View All Invoices
    // URL: GET http://localhost:8080/invoice/viewall
    @GetMapping("/viewall")
    public ResponseEntity<?> getAllInvoices() {
        try {
            List<Invoice> invoices = invoiceService.getAllInvoices();
            if (invoices.isEmpty()) {
                return new ResponseEntity<>("No invoices found.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching invoices: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - View Invoice by ID
    // URL: GET http://localhost:8080/invoice/view/{id}
    @GetMapping("/view/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String id) {
        try {
            Invoice invoice = invoiceService.getInvoiceById(id);
            if (invoice == null) {
                return new ResponseEntity<>("Invoice not found with ID: " + id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching invoice: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
