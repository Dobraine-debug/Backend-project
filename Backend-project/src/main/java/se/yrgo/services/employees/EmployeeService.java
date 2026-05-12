package se.yrgo.services.employees;

import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;
import se.yrgo.services.bookings.TableNotFoundException;

import java.util.List;

public interface EmployeeService {
    // Employee
    List<Employee> getAllEmployees();
    Employee findEmployeeById(String employeeId) throws EmployeeNotFoundException;
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employeeToUpdate) throws EmployeeNotFoundException;
    void deleteEmployee(Employee employeeToDelete) throws EmployeeNotFoundException;

    // Schedule
    List<Schedule> getAllSchedules();
    List<Schedule> findSchedulesByEmployee(String employeeId);
    List<Schedule> findSchedulesByTable(String tableId);
    List<Schedule> findSchedulesByDate(String date);

    Schedule findScheduleById(String scheduleId) throws ScheduleNotFoundException;
    void saveSchedule(Schedule schedule) throws TableNotFoundException, EmployeeNotFoundException;
    void updateSchedule(Schedule scheduleToUpdate) throws ScheduleNotFoundException;
    void deleteSchedule(Schedule scheduleToDelete) throws ScheduleNotFoundException;

    void deleteAll();
}
