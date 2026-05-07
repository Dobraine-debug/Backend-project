package se.yrgo.data;

import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;
import se.yrgo.services.employees.EmployeeNotFoundException;
import se.yrgo.services.employees.ScheduleNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeServiceDao {
    // Employee
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String employeeId) throws EmployeeNotFoundException;
    void createEmployee(Employee employee);
    void updateEmployee(Employee employeeToUpdate) throws EmployeeNotFoundException;
    void deleteEmployee(Employee employeeToDelete) throws EmployeeNotFoundException;

    // Schedule

}
