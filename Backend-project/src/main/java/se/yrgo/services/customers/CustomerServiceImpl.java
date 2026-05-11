package se.yrgo.services.customers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import se.yrgo.data.customers.CustomerServiceDao;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;

import java.util.List;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerServiceDao dao;

    @Override
    public List<Customer> showCustomers() {
        return dao.allCustomers();
    }

    @Override
    public Customer findCustomer(String customerId) throws CustomerNotFoundException {
        return dao.findById(customerId);
    }

    @Override
    public List<Invoice> showInvoices() {
        return dao.allInvoices();
    }

    @Override
    public Invoice showInvoice(String invoiceId) throws InvoiceNotFoundException {
        return dao.findInvoice(invoiceId);
    }

    @Override
    public List<Invoice> findInvoices(String customerId) {
        List<Invoice> invoices =  dao.getInvoicesByCustomer(customerId);
        return invoices;
    }

    @Override
    public void newCustomer(Customer newCustomer) {
        dao.createCustomer(newCustomer);

    }

    @Override
    public void newInvoice(Invoice newInvoice) {
        dao.createInvoice(newInvoice);

    }

    @Override
    public void removeInvoice(String invoiceId, String customerId) throws InvoiceNotFoundException, CustomerNotFoundException {
        dao.deleteInvoice(invoiceId, customerId);
    }


    @Override
    public void addInvoice(Invoice invoice, String customerId) throws CustomerNotFoundException {
        dao.addInvoiceToCustomer(invoice, customerId);
    }

    @Override
    public void deleteAll() {
        dao.purge();
    }
}
