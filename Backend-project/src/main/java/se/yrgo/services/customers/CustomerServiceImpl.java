package se.yrgo.services.customers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.yrgo.data.CustomerServiceDao;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;

import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerServiceDao dao;

    @Override
    public List<Customer> showCustomers() {
        return dao.allCustomers();
    }

    @Override
    public Customer findCustomer(String customerId) {
        return dao.findById(customerId);
    }

    @Override
    public List<Invoice> showInvoices() {
        return dao.allInvoices();
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
    public void removeInvoice(String invoiceId) {
        dao.deleteInvoice(invoiceId);

    }

    @Override
    public void addInvoice(Invoice invoice, String customerId) {
        dao.addInvoiceToCustomer(invoice, customerId);
    }
}
