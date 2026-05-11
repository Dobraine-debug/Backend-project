package se.yrgo.domains;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String invoiceId;
    private double amount;
    private LocalDate invoiceDate;

    public Invoice(){};

    public Invoice(String invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.invoiceDate = LocalDate.now();
    }

    public String getInvoiceId() {
        return invoiceId;
    }
    public double getAmount() {
        return amount;
    }
    public LocalDate getInvoiceDate() { return invoiceDate; }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString(){
        return "Invoice ID: " + invoiceId + "\nAmount: " + amount + "\nDate: " + invoiceDate + "\nCustomer ID: " +"\n";
    }
}
