package se.yrgo.integrationtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.customers.CustomerService;
import se.yrgo.services.customers.InvoiceNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Skansholm
 * Integration test for operations based on CustomerService interface.
 */

@ContextConfiguration({"/application.xml", "/datasource-test.xml"})
@Transactional
@ExtendWith(SpringExtension.class)
public class CustomerServiceIntegrationTest {
    @Autowired
    private CustomerService service;

    @Test
    public void testFindCustomerById() throws CustomerNotFoundException {
        Customer testCustomer =
                new Customer("T101", "Test Testingsson", "test@test.com", "0733-123456");
        service.newCustomer(testCustomer);
        Customer foundCustomer = service.findCustomer("T101");
        assertEquals(testCustomer, foundCustomer);
    }

    @Test
    public void testFindAllCustomers(){
        Customer testCustomer1 = new Customer("T101", "Test Testingsson",
                "test@test.com", "0733-123456");
        Customer testCustomer2 = new Customer("T102", "Test Testingsson",
                "test@test.com", "0733-123456");
        service.newCustomer(testCustomer1);
        service.newCustomer(testCustomer2);
        List<Customer> customers = service.showCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    public void findInvoiceById(){
        Invoice testInvoice = new Invoice("T201", 300);
        service.newInvoice(testInvoice);
        try {
            Invoice foundInvoice = service.showInvoice("T201");
            assertEquals(testInvoice, foundInvoice);
        } catch (InvoiceNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void findInvoiceByCustomerId() throws CustomerNotFoundException {
        Customer testCustomer = new Customer("T101", "Test Testingsson",
                "test@test.com", "0733-123456");
        Invoice testInvoice = new Invoice("T201", 300);
        service.newCustomer(testCustomer);
        service.addInvoice(testInvoice, "T101");
        List<Invoice> foundInvoice = service.findInvoices("T101");
        assertEquals(testInvoice, foundInvoice.get(0));
    }

    @Test
    public void deleteInvoice() throws CustomerNotFoundException, InvoiceNotFoundException {
        Customer testCustomer = new Customer("T101", "Test Testingsson",
                "test@test.com", "0733-123456");
        Invoice testInvoice = new Invoice("T201", 300);
        service.newCustomer(testCustomer);
        service.addInvoice(testInvoice, "T101");
        service.removeInvoice("T201", "T101");
        List<Invoice> foundInvoices = service.showInvoices();
        assertEquals(0, foundInvoices.size());

    }
}
