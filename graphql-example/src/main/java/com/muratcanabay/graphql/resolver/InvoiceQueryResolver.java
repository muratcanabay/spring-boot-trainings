package com.muratcanabay.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.muratcanabay.entity.Invoice;
import com.muratcanabay.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InvoiceQueryResolver implements GraphQLQueryResolver {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getInvoiceByDescriptionLike(String description){
        return invoiceRepository.getInvoiceByDescriptionLike(description);
    }

    public Optional<Invoice> getById(Long id) {
        return invoiceRepository.findById(id);
    }
}
