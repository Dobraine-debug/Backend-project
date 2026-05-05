package se.yrgo.domains;
import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private double amount;
    private LocalDate invoiceDate;

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
}
