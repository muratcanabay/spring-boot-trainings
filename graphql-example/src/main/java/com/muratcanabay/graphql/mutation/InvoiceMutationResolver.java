package com.muratcanabay.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.muratcanabay.dto.InvoiceDto;
import com.muratcanabay.entity.Invoice;
import com.muratcanabay.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceMutationResolver implements GraphQLMutationResolver {

    private final InvoiceRepository invoiceRepository;

    private final ModelMapper modelMapper;

    public Invoice createInvoice(InvoiceDto invoiceDto) {
        return invoiceRepository.save(modelMapper.map(invoiceDto, Invoice.class));
    }
}
