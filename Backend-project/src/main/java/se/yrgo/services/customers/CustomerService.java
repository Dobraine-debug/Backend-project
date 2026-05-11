package se.yrgo.services.customers;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;

import java.util.List;

public interface CustomerService {
    public List<Customer> showCustomers();
    public Customer findCustomer(String customerId);
    public List<Invoice> showInvoices();
    public Invoice showInvoice(String invoiceId);
    public List<Invoice> findInvoices(String customerId);
    public void newCustomer(Customer newCustomer);
    public void newInvoice(Invoice newInvoice);
    public void removeInvoice(String invoiceId, String customerId);
    public void addInvoice(Invoice invoice, String customerId);
    public void deleteAll();
}
