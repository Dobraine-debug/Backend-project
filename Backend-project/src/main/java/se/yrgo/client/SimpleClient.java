package se.yrgo.client;


import jakarta.persistence.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.data.SampleData;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;
import se.yrgo.services.customers.CustomerService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        try  {
            Boolean showMenu = true;
            Boolean customerCheck = false;
            Boolean invoiceCheck = false;
            CustomerService service = container.getBean(CustomerService.class);
            SampleData data = new SampleData();
            data.addData(service);
            System.out.println("Welcome to the administrative system of Restaurant Backend.");
            Thread.sleep(1000);
            Scanner sc = new Scanner(System.in);
            while(showMenu){
                System.out.println("Do you want to:" +"\n1: Manage customers" + "\n2: Manage invoices" + "\n3: Exit");
                String selection = sc.nextLine();
                if(selection.equals("1")){
                    customerCheck = true;
                }
                else if (selection.equals("2")) {
                    invoiceCheck = true;
                }
                else if (selection.equals("3")){
                    showMenu = false;
                }
                while(customerCheck){
                    System.out.println("Please select action:");
                    Thread.sleep(1000);
                    System.out.println("1: View all customers" + "\n2: Find customer based on ID"
                            + "\n3: Add new customer" + "\n4: Return to main menu");
                    selection = sc.nextLine();
                    if(selection.equals("1")){
                        List<Customer> customers = service.showCustomers();
                        for(Customer customer : customers){
                            System.out.println(customer.getCustomer());
                        }
                    } else if (selection.equals("2")) {
                        System.out.println("Please enter customer ID: ");
                        String id = sc.nextLine();
                        Thread.sleep(1000);
                        Customer customer = service.findCustomer(id);
                        System.out.println(customer.getCustomer());
                    } else if (selection.equals("3")) {
                        System.out.println("Please enter customer ID: ");
                        String id = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please enter customer name: ");
                        String name = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please enter customer e-mail: ");
                        String mail = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please enter customer telephone number: ");
                        String phone = sc.nextLine();
                        Customer customer = new Customer(id, name, mail, phone);
                        service.newCustomer(customer);
                        Thread.sleep(1000);
                        System.out.println("Customer successfully added!");
                    } else if (selection.equals("4")) {
                        customerCheck = false;
                    }

                }
                while(invoiceCheck){
                    System.out.println("Please select action:");
                    Thread.sleep(1000);
                    System.out.println("1: View all invoices" + "\n2: Find all invoices based on customer ID"
                            + "\n3: Create new invoice" +  "\n4: Delete invoice" + "\n5: Return to main menu");
                    selection = sc.nextLine();
                    if(selection.equals("1")){
                        List<Invoice> invoices = service.showInvoices();
                        for(Invoice invoice : invoices){
                            System.out.println(invoice);
                        }
                    }
                    else if(selection.equals("2")){
                        Thread.sleep(1000);
                        System.out.println("Please write customer ID:");
                        String id = sc.nextLine();
                        List<Invoice> invoices = service.findInvoices(id);
                        for(Invoice invoice : invoices){
                            System.out.println(invoice);
                        }
                    }
                    else if(selection.equals("3")){
                        Thread.sleep(1000);
                        System.out.println("Please write customer ID:");
                        String customerId = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please write invoice ID:");
                        String invoiceId = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please write invoice amount:");
                        double amount = Double.valueOf(sc.nextLine());
                        Invoice invoice = new Invoice(invoiceId, amount);
                        service.newInvoice(invoice);
                        service.addInvoice(invoice, customerId);
                    }
                    else if(selection.equals("4")){
                        System.out.println("Please write invoice ID:");
                        String invoiceId = sc.nextLine();
                        Thread.sleep(1000);
                        System.out.println("Please write customer ID:");
                        String customerId = sc.nextLine();
                        service.removeInvoice(invoiceId, customerId);
                    }
                    else if(selection.equals("5")){
                        invoiceCheck = false;
                    }
                }



            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            container.close();
        }

    }

}