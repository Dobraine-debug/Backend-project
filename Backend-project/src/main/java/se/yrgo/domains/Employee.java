package main.java.se.yrgo.domains;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String name;
    private String telephone;
    private String email;
    private List<String> tables;

    public Employee(String employeeId, String name, String telephone, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        tables = new ArrayList<>();
    }

    // TODO:
//    public void addTable(Table table) {
//        tables.add(table);
//    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee name: " + name + ", id: " + employeeId + ", telephone: " + telephone + ", email: " + email;
    }
}
