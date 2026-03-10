package com.klef.fsad.exam.repository;

import com.klef.fsad.exam.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    // Find invoices by status
    List<Invoice> findByStatus(String status);

    // Find invoices by name (case-insensitive)
    List<Invoice> findByNameContainingIgnoreCase(String name);
}
