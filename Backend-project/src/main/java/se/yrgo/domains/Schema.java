package main.java.se.yrgo.domains;

import java.time.LocalTime;

public class Schema {
    private String schemaId;
    private Employee employee;
    // TODO:
    // private Table table;
    private LocalTime start;
    private LocalTime end;

    // TODO: add table
    public Schema(String schemaId, Employee employee, LocalTime start, LocalTime end) {
        this.schemaId = schemaId;
        this.employee = employee;
        this.start = start;
        this.end = end;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    // TODO: add table
    @Override
    public String toString() {
        return "Schema id: " + schemaId + ", employee: " + employee + ", start: " + start + ", end: " + end;
    }
}
