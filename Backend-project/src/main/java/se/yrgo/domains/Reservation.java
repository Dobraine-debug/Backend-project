package se.yrgo.domains;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Represents a booking/reservation in the restaurant's system.
 * One reservation is connected to:
 * - one Customer
 * - one RestaurantTable
 * - one Session
 */
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int reservationId;
    private LocalDate date;
    private int sizeOfParty;
    /**
     * Represents the time of reservation.
     */
    @Enumerated(EnumType.STRING)
    private Session session;
    /**
     * Represents the customer who made the reservation.
     */
    @ManyToOne
    private Customer customer;
    /**
     * Represents the table connected to the reservation.
     */
    @ManyToOne
    private RestaurantTable restaurantTable;

    public Reservation(Customer customer, RestaurantTable restaurantTable, Session session, LocalDate date, int sizeOfParty){
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
        return "\nDate: " + date +
                "\nCustomer: " + customer.getName() +
                "\nTable: " + restaurantTable.getTableId() +
                "\nSession: " + session.getTime() +
                "\nSize of party: " + sizeOfParty;
    }
}
