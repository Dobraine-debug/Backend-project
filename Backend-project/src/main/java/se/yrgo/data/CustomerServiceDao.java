package se.yrgo.data;
import se.yrgo.domains.*;

import java.util.List;

public interface CustomerServiceDao {
    public List<Customer> allCustomers();
    public Customer findById(String customerId);
    public List<Invoice> allInvoices();
    public List<Invoice> getInvoicesByCustomer(String customerId);
    public void addInvoiceToCustomer(Invoice invoice, String customerId);
    public void createCustomer(Customer newCustomer);
    public void createInvoice(Invoice newInvoice);
    public void deleteInvoice(String invoiceId);

}
