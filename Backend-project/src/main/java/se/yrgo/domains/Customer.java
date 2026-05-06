package se.yrgo.domains;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private int customerId;
    private String name;
    private String mail;
    private String telephone;
    private String invoice;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(int customerId, String name, String mail, String telephone){
        this.customerId = customerId;
        this.name = name;
        this.mail = mail;
        this.telephone = telephone;
    }

    public List<Reservation> getReservations() { return reservations; }

    public String getCustomer(){
        return "Id: " + customerId + " Name: " + name + " Mail: " + mail + " Telephone: " + telephone;
    }

    public int getCustomerId(){return customerId;}
    public String getName() {return name;}
    public String getMail(){return mail;}
    public String getTelephone(){return telephone;}
    public String getInvoice(){return invoice;}

    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public void setName(String name) {this.name = name;}
    public void setMail(String mail) {this.mail = mail;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public void setInvoice(String invoice) {this.invoice = invoice;}
}
