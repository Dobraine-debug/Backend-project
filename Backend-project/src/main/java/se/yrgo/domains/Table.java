package se.yrgo.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int tableId;
    private int numberOfSeats;
    private TableStatus status;

    @OneToMany(mappedBy = "table")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "table")
    private List<Reservation> reservations = new ArrayList<>();

    public Table(int tableId, int numberOfSeats) {
        this.tableId = tableId;
        this.numberOfSeats = numberOfSeats;
        this.status = TableStatus.AVAILABLE;
    }

    public Table() {

    }

    public List<Reservation> getReservations() { return reservations; }

    public List<Schedule> getSchedules() { return schedules; }

    public boolean isAvailable() {
        return status == TableStatus.AVAILABLE;
    }

    public int getId() { return id; }
    public int getTableId() { return tableId; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public TableStatus getStatus() { return status; }

    @Override
    public String toString() {
        return "Table: " + tableId + "\nNumber of seats: " + numberOfSeats + "\nStatus: " + status;
    }
}
