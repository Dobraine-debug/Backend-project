package se.yrgo.data;

import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;
import se.yrgo.services.bookings.TableNotFoundException;
import se.yrgo.services.employees.EmployeeNotFoundException;
import se.yrgo.services.employees.ScheduleNotFoundException;

import java.util.List;

public interface EmployeeServiceDao {
    // Employee
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String employeeId) throws EmployeeNotFoundException;
    void createEmployee(Employee employee);
    void updateEmployee(Employee employeeToUpdate) throws EmployeeNotFoundException;
    void deleteEmployee(Employee employeeToDelete) throws EmployeeNotFoundException;

    // Schedule
    List<Schedule> getAllSchedules();
    List<Schedule> getSchedulesByEmployee(String employeeId);
    List<Schedule> getSchedulesByTable(String tableId);
    List<Schedule> getSchedulesByDate(String date);

    Schedule getScheduleById(String scheduleId) throws ScheduleNotFoundException;
    void createSchedule(Schedule schedule) throws TableNotFoundException, EmployeeNotFoundException;
    void updateSchedule(Schedule scheduleToUpdate) throws ScheduleNotFoundException;
    void deleteSchedule(Schedule scheduleToDelete) throws ScheduleNotFoundException;
}
