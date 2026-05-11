package se.yrgo.data;
import jakarta.persistence.EntityTransaction;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;

import java.util.List;

@Transactional
@Repository
public class CustomerServiceDaoJpaImpl implements CustomerServiceDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Customer> allCustomers() {
        return em.createQuery("select customer from Customer as customer").getResultList();
    }

    @Override
    public Customer findById(String customerId) {
        return (Customer) em.createQuery("select customer from Customer as customer where customer.customerId=:customerId")
                .setParameter("customerId", customerId).getSingleResult();
    }

    @Override
    public List<Invoice> allInvoices() {
        return em.createQuery("select invoice from Invoice as invoice").getResultList();
    }

    @Override
    public List<Invoice> getInvoicesByCustomer(String customerId) {
        Customer customer = (Customer) em.createQuery("select customer from Customer as customer where customer.customerId=:customerId")
                .setParameter("customerId", customerId).getSingleResult();
        List<Invoice> invoices = customer.getInvoices();
        return invoices;
    }

    @Override
    public Invoice findInvoice(String invoiceId) {
        Invoice invoice = (Invoice) em.createQuery("select invoice from Invoice as invoice where invoice.invoiceId=:invoiceId")
                .setParameter("invoiceId", invoiceId).getSingleResult();
        return invoice;
    }

    @Override
    public void addInvoiceToCustomer(Invoice invoice, String customerId) {
        Customer customer = (Customer) em.createQuery("select customer from Customer as customer " +
                        "where customer.customerId=:customerId")
                .setParameter("customerId", customerId).getSingleResult();
        customer.addInvoice(invoice);
        em.persist(invoice);
        em.persist(customer);

    }

    @Override
    public void createCustomer(Customer newCustomer) {
        em.persist(newCustomer);

    }

    @Override
    public void createInvoice(Invoice newInvoice) {
        em.persist(newInvoice);

    }

    @Override
    public void purge() {
        List<Customer> customers = allCustomers();
        List<Invoice> invoices = allInvoices();
        for(Invoice invoice : invoices) {
            em.remove(invoice);
        }
        for(Customer customer : customers){
            em.remove(customer);
        }

    }

    @Override
    public void deleteInvoice(String invoiceId, String customerId) {
        Invoice invoiceToBeDeleted = (Invoice) em.createQuery("select invoice from Invoice as invoice " +
                        "where invoice.invoiceId=:invoiceId").setParameter("invoiceId", invoiceId)
                .getSingleResult();
        Customer customer = (Customer) em.createQuery("select customer from Customer as customer where customer.customerId=:customerId")
                .setParameter("customerId", customerId).getSingleResult();
        customer.removeInvoice(invoiceToBeDeleted);
        em.merge(customer);
        em.remove(invoiceToBeDeleted);

    }
}
