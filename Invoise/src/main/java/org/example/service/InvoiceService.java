package org.example.service;

import org.example.entity.Invoice;
import org.example.repository.InvoiceRepository;

public class InvoiceService {
    private static long lastNumberNotGiven = 0L;
    private static final InvoiceRepository invoiceRepository = new InvoiceRepository();

    private InvoiceService() {
    }

    public static void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf(++lastNumberNotGiven));
        invoiceRepository.create(invoice);
    }
}
