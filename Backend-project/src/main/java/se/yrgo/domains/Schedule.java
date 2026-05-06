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

    // Creates a column employee_fk in schema-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_FK")
    private Employee employee;

    // Creates a column table_fk in schema-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="TABLE_FK")
    private Table table;

    public Schedule(String scheduleId, Employee employee, Table table, LocalDate date) {
        this.scheduleId = scheduleId;
        this.employee = employee;
        this.table = table;
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

    public Table getTable() {
        return table;
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

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Schema id: " + scheduleId + ", employee: " + employee + ", tables: " + table + ", date: " + date;
    }
}
