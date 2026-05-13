package se.yrgo.services.customers;

/**
 * @author David Skansholm
 * Custom exception for when an object of the invoice class
 * isn't found in the database.
 */

public class InvoiceNotFoundException extends Exception{
    public InvoiceNotFoundException() {
        super("Invoice not found");
    }
}
