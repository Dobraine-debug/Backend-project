package se.yrgo.domains;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int reservationId;
    private LocalDate date;
    private int sizeOfParty;

    @Enumerated(EnumType.STRING)
    private Session session;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Table table;

    public Reservation(int reservationId, Customer customer, Table table, Session session, LocalDate date, int sizeOfParty){
        this.reservationId = reservationId;
        this.customer = customer;
        this.table = table;
        this.session = session;
        this.date = date;
        this.sizeOfParty = sizeOfParty;
    }

    public Reservation() {

    }

    public int getId() { return id; }
    public int getReservationId(){return reservationId;}
    public Customer getCustomer(){ return customer; }
    public Table getTable(){return table;}
    public Session getSession() { return session; }
    public LocalDate getDate() { return date; }
    public int getSizeOfParty() { return sizeOfParty; }

    public void setReservationId(int reservationId) {this.reservationId = reservationId;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public void setTable(Table table) {this.table = table;}
    public void setSession(Session session) { this.session = session; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setSizeOfParty(int sizeOfParty) { this.sizeOfParty = sizeOfParty; }

    @Override
    public String toString(){
        return "Reservation ID: " + reservationId +
                "\nDate: " + date +
                "\nCustomer: " + customer.getName() +
                "\nTable: " + table.getTableId() +
                "\nSession: " + session.getTime() +
                "\nSize of party: " + sizeOfParty;
    }
}
