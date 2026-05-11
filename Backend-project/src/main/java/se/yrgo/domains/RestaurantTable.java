package se.yrgo.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tableId;
    private int numberOfSeats;

    @OneToMany(mappedBy = "restaurantTable")
    private List<Schedule> schedules = new ArrayList<>();

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

    public void addScheduleForTable(Schedule schedule) {
        schedules.add(schedule);
        schedule.setTable(this);
    }

    @Override
    public String toString() {
        return "Table: " + tableId + "\nNumber of seats: " + numberOfSeats;
    }
}
