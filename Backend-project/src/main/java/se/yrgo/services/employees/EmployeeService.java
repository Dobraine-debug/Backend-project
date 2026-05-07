package se.yrgo.services.employees;

import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;

import java.time.LocalDate;
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
    List<Schedule> findSchedulesForEmployee(String employeeId) throws EmployeeNotFoundException;
    List<Schedule> findSchedulesForTable(String tableId);
    List<Schedule> findSchedulesForDate(LocalDate date);

    Schedule findScheduleById(String scheduleId) throws ScheduleNotFoundException;
    void saveSchedule(Schedule schedule);
    void updateSchedule(Schedule scheduleToUpdate) throws ScheduleNotFoundException;
    void deleteSchedule(Schedule scheduleToDelete) throws ScheduleNotFoundException;
}
