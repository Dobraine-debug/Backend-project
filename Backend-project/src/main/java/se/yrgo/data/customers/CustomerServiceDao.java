package se.yrgo.data.customers;
import se.yrgo.domains.*;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.customers.InvoiceNotFoundException;

import java.util.List;

public interface CustomerServiceDao {
    public List<Customer> allCustomers();
    public Customer findById(String customerId) throws CustomerNotFoundException;
    public List<Invoice> allInvoices();
    public List<Invoice> getInvoicesByCustomer(String customerId);
    public Invoice findInvoice(String invoiceId) throws InvoiceNotFoundException;
    public void addInvoiceToCustomer(Invoice invoice, String customerId) throws CustomerNotFoundException;
    public void createCustomer(Customer newCustomer);
    public void createInvoice(Invoice newInvoice);
    public void deleteInvoice(String invoiceId, String customerId) throws InvoiceNotFoundException, CustomerNotFoundException;
    public void purge();

}

