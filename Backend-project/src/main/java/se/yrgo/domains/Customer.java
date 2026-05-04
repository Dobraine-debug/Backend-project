package se.yrgo.domains;

public class Customer {
    private String customerId;
    private String name;
    private String mail;
    private String telephone;
    private String invoice;

    public Customer(String customerId, String name, String mail, String telephone){
        this.customerId = customerId;
        this.name = name;
        this.mail = mail;
        this.telephone = telephone;
    }

    public String getCustomer(){
        return "Id: " + customerId + " Name: " + name + " Mail: " + mail + " Telephone: " + telephone;
    }

    public String getCustomerId(){return customerId;}
    public String getName() {return name;}
    public String getMail(){return name;}
    public String getTelephone(){return telephone;}
    public String getInvoice(){return invoice;}

    public void setCustomerId(String customerId) {this.customerId = customerId;}
    public void setName(String name) {this.name = name;}
    public void setMail(String mail) {this.mail = mail;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public void setInvoice(String invoice) {this.invoice = invoice;}
}
