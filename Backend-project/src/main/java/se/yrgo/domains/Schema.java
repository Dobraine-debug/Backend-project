package se.yrgo.domains;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schema {
    private String schemaId;
    private Employee employee;
    private List<Table> tables;
    private LocalTime start;
    private LocalTime end;

    public Schema(String schemaId, Employee employee, List<Table> tables, LocalTime start, LocalTime end) {
        this.schemaId = schemaId;
        this.employee = employee;
        this.tables = new ArrayList<>(tables);
        this.start = start;
        this.end = end;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Table> getTables() {
        return tables;
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

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Schema id: " + schemaId + ", employee: " + employee + ", tables: " + tables + ", start: " + start + ", end: " + end;
    }
}
