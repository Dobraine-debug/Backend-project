package se.yrgo.domains;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scheduleId;

    // Creates a column employee_fk in schema-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_FK")
    private Employee employee;

    // Creates a column table_fk in schema-table (instead of creating a new table)
    @ManyToOne
    @JoinColumn(name="TABLE_FK")
    private Table table;

    private LocalDate date;

    public Schedule(String scheduleId, Employee employee, Table table, LocalDate date) {
        this.scheduleId = scheduleId;
        this.employee = employee;
        this.table = table;
        this.date = date;
    }

    public Schedule() {

    }

    public String getSchemaId() {
        return scheduleId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Table getTable() {
        return table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSchemaId(String schemaId) {
        this.scheduleId = schemaId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTable(List<Table> tables) {
        this.table = table;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Schema id: " + scheduleId + ", employee: " + employee + ", tables: " + table + ", date: " + date;
    }
}
