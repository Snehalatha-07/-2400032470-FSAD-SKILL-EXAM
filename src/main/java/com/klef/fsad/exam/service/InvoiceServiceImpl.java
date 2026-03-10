package com.klef.fsad.exam.service;

import com.klef.fsad.exam.model.Invoice;
import com.klef.fsad.exam.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public String addInvoice(Invoice invoice) {
        // Invoice ID must not be null
        if (invoice.getInvoiceId() == null || invoice.getInvoiceId().isEmpty()) {
            return "Invoice ID must not be null or empty!";
        }

        // Check if Invoice ID already exists
        if (invoiceRepository.existsById(invoice.getInvoiceId())) {
            return "Invoice with ID " + invoice.getInvoiceId() + " already exists!";
        }

        invoiceRepository.save(invoice);
        return "Invoice Added Successfully with ID: " + invoice.getInvoiceId();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(String invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        return invoice.orElse(null);
    }
}
