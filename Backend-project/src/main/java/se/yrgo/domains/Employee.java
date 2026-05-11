package se.yrgo.domains;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee class represents an employee in a restaurant.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employeeId;
    private String name;
    private String telephone;
    private String email;

    // An employee has many schedule entries.
    // Gives a list of all schedules for an employee
    @OneToMany(mappedBy = "employee")
    private List<Schedule> employeeScheduleList = new ArrayList<>();

    public Employee(String employeeId, String name, String telephone, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    public Employee() {

    }

    /**
     * Adds schedule to the list of an employee. Maintains bidirectional relationship.
     * @param schedule
     */
    public void addScheduleForEmployee(Schedule schedule) {
        this.employeeScheduleList.add(schedule);
        schedule.setEmployee(this);
    }

    public List<Schedule> getEmployeeScheduleList() {
        return employeeScheduleList;
    }

    public int getId() { return id; }

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
