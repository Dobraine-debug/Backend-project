package se.yrgo.data;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;
import se.yrgo.services.customers.CustomerService;

public class SampleData {
    public void addData(CustomerService customer){
        customer.deleteAll();
        Customer customer1 = new Customer("C101", "David Skansholm",
                "david@skansholm.com", "0736-230384");
        Customer customer2 = new Customer("C102", "Erik Granqvist",
                "granqvist@gmail.com", "0735-190310");
        Customer customer3 = new Customer("C103", "Joel Fridh",
                "fridh@gmail.com", "0777-160952");
        Customer customer4 = new Customer("C104", "Hanna Haglund",
                "haglund@gmail.com", "0765-329218");
        Customer customer5 = new Customer("C105", "Josefina Runnquist",
                "runnquist@gmail.com", "0775-200986");
        Invoice invoice1 = new Invoice("I101", 300);
        Invoice invoice2 = new Invoice("I102", 250);
        Invoice invoice3 = new Invoice("I103", 400);
        Invoice invoice4 = new Invoice("I104", 600);
        Invoice invoice5 = new Invoice("I105", 750);
        Invoice invoice6 = new Invoice("I106", 150);
        customer.newCustomer(customer1);
        customer.newCustomer(customer2);
        customer.newCustomer(customer3);
        customer.newCustomer(customer4);
        customer.newCustomer(customer5);
        customer.addInvoice(invoice1, "C101");
        customer.addInvoice(invoice2, "C103");
        customer.addInvoice(invoice3, "C103");
        customer.addInvoice(invoice4, "C104");
        customer.addInvoice(invoice5, "C105");
        customer.addInvoice(invoice6, "C105");
    }
}
