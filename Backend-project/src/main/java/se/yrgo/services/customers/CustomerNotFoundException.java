package se.yrgo.services.customers;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
