package se.yrgo.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerId;
    private String name;
    private String mail;
    private String telephone;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(){}

    public Customer(String customerId, String name, String mail, String telephone){
        this.customerId = customerId;
        this.name = name;
        this.mail = mail;
        this.telephone = telephone;
    }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public void removeInvoice(Invoice invoice){
        invoices.remove(invoice);
    }

    public String getCustomer(){
        return "Id: " + customerId + " Name: " + name + " Mail: " + mail + " Telephone: " + telephone;
    }

    public String getCustomerId(){return customerId;}
    public String getName() {return name;}
    public String getMail(){return name;}
    public String getTelephone(){return telephone;}
    public List<Invoice> getInvoices(){return invoices;}

    public void setCustomerId(String customerId) {this.customerId = customerId;}
    public void setName(String name) {this.name = name;}
    public void setMail(String mail) {this.mail = mail;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
}
