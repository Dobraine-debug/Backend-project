package se.yrgo.services.customers;

/**
 * @author David Skansholm
 * Custom exception for when an object of the customer class
 * isn't found in the database.
 */

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
