package se.yrgo.domains;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    private int reservationId;
    private Session session;
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Table table;


    public Reservation(int reservationId, Customer customer, Table table, Session session, LocalDate date){
        this.reservationId = reservationId;
        this.customer = customer;
        this.table = table;
        this.session = session;
        this.date = date;
    }

    public int getReservationId(){return reservationId;}
    public Customer getCustomer(){return customer;}
    public Table getTable(){return table;}
    public Session getSession() { return session; }

    public void setReservationId(int reservationId) {this.reservationId = reservationId;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public void setTable(Table table) {this.table = table;}
    public void setSession(Session session) { this.session = session; }

    @Override
    public String toString(){
        return "Id: " + reservationId + "\n" + customer.getCustomer() + "\n" + "Table: " + table + "\n" + "Session: "
                + session;
    }
}
