package se.yrgo.domains;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String scheduleId;
    private LocalDate date;

    // Creates a column employee_fk in schedule-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_FK")
    private Employee employee;

    // Creates a column table_fk in schedule-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="TABLE_FK")
    private RestaurantTable restaurantTable;

    public Schedule(String scheduleId, Employee employee, RestaurantTable restaurantTable, LocalDate date) {
        this.scheduleId = scheduleId;
        this.employee = employee;
        this.restaurantTable = restaurantTable;
        this.date = date;
    }

    public Schedule() {

    }


    public int getId() {
        return id;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public RestaurantTable getTable() {
        return restaurantTable;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTable(RestaurantTable restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    @Override
    public String toString() {
        return "Schema id: " + scheduleId + ", employee: " + employee + ", tables: " + restaurantTable + ", date: " + date;
    }
}
