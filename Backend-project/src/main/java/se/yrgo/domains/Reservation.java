package se.yrgo.domains;

import java.time.LocalTime;

public class Reservation {
    private String reservationId;
    private Customer customer;
    private String table;
    private LocalTime startTime;
    private LocalTime endTime;

    public Reservation(String reservationId, Customer customer, String table, LocalTime startTime, LocalTime endTime){
        this.reservationId = reservationId;
        this.customer = customer;
        this.table = table;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getReservationId(){return reservationId;}
    public Customer getCustomer(){return customer;}
    public String getTable(){return table;}
    private LocalTime getStartTime(){return startTime;}
    private LocalTime getEndTime(){return endTime;}

    public void setReservationId(String reservationId) {this.reservationId = reservationId;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public void setTable(String table) {this.table = table;}
    public void setStartTime(LocalTime startTime) {this.startTime = startTime;}
    public void setEndTime(LocalTime endTime) {this.endTime = endTime;}

    @Override
    public String toString(){
        return "Id: " + reservationId + "\n" + customer.getCustomer() + "\nTable: " + table + "\nStart: "
                + startTime.toString() + "\nEnd: " + endTime.toString();
    }
}
