package org.example;

import org.example.entity.Invoice;
import org.example.service.InvoiceService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("What is the customer name ? ");
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        InvoiceService.createInvoice(invoice);

    }
}
