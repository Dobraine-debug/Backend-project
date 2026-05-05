package se.yrgo.domains;
import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private double amount;
    private boolean paid;
    private LocalDate invoiceDate;

    public Invoice(String invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.paid = false;
        this.invoiceDate = LocalDate.now();
    }

    public void markAsPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public double getAmount() {
        return amount;
    }
}
