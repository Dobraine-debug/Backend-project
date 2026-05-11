package se.yrgo.services.customers;

public class InvoiceNotFoundException extends Exception{
    public InvoiceNotFoundException() {
        super("Invoice not found");
    }
}
