package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.Invoice;

import java.util.List;

public interface InvoiceService {

    // Add a new Invoice
    String addInvoice(Invoice invoice);

    // Get all Invoices
    List<Invoice> getAllInvoices();

    // Get Invoice by ID
    Invoice getInvoiceById(String invoiceId);
}
