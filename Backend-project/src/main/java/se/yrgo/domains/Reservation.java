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
    private RestaurantTable restaurantTable;

    public Reservation(int reservationId, Customer customer, RestaurantTable restaurantTable, Session session, LocalDate date, int sizeOfParty){
        this.reservationId = reservationId;
        this.customer = customer;
        this.restaurantTable = restaurantTable;
        this.session = session;
        this.date = date;
        this.sizeOfParty = sizeOfParty;
    }

    public Reservation() {

    }

    public int getId() { return id; }
    public int getReservationId(){return reservationId;}
    public Customer getCustomer(){ return customer; }
    public RestaurantTable getTable(){return restaurantTable;}
    public Session getSession() { return session; }
    public LocalDate getDate() { return date; }
    public int getSizeOfParty() { return sizeOfParty; }

    public void setReservationId(int reservationId) {this.reservationId = reservationId;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public void setTable(RestaurantTable restaurantTable) {this.restaurantTable = restaurantTable;}
    public void setSession(Session session) { this.session = session; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setSizeOfParty(int sizeOfParty) { this.sizeOfParty = sizeOfParty; }

    @Override
    public String toString(){
        return "Reservation ID: " + reservationId +
                "\nDate: " + date +
                "\nCustomer: " + customer.getName() +
                "\nTable: " + restaurantTable.getTableId() +
                "\nSession: " + session.getTime() +
                "\nSize of party: " + sizeOfParty;
    }
}
