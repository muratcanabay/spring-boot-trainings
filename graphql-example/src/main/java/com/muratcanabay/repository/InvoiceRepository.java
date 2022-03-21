package com.muratcanabay.repository;

import com.muratcanabay.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> getInvoiceByDescriptionLike(String description);

}
