package se.yrgo.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a physical table in the restaurant.
 * A table can have multiple schedules and reservations connected to it.
 */
@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tableId;
    private int numberOfSeats;
    /**
     * Represents schedules connected to this table.
     * mappedBy refers to the "table" field in Schedule.
     */
    @OneToMany(mappedBy = "table")
    private List<Schedule> schedules = new ArrayList<>();
    /**
     * Reservations connected to this table.
     */
    @OneToMany(mappedBy = "restaurantTable")
    private List<Reservation> reservations = new ArrayList<>();

    public RestaurantTable(String tableId, int numberOfSeats) {
        this.tableId = tableId;
        this.numberOfSeats = numberOfSeats;
    }

    public RestaurantTable() { }

    public List<Reservation> getReservations() { return reservations; }
    public List<Schedule> getSchedules() { return schedules; }
    public int getId() { return id; }
    public String getTableId() { return tableId; }
    public int getNumberOfSeats() { return numberOfSeats; }

    /**
     *
     * @param schedule
     * Adds a schedule to this table and updates
     * the owning side of the relationship.
     */
    public void addScheduleForTable(Schedule schedule) {
        schedules.add(schedule);
        schedule.setTable(this);
    }

    @Override
    public String toString() {
        return "Table: " + tableId + "\nNumber of seats: " + numberOfSeats;
    }
}
