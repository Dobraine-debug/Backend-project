package se.yrgo.services.employees;

import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;

import java.util.List;

public interface EmployeeService {
    public List<Employee> showAllEmployees();
    public Employee getEmployeeById(String employeeId);
    public Employee getEmployeeByName(String name);
    public void addNewEmployee(Employee employee);
    public void deleteEmployee(String employeeId);

    public List<Schedule> showAllSchedules();
    public List<Schedule> showSchedulesForEmployeeId(String employeeId);
    public List<Schedule> showSchedulesForTable(String tableId);
    public Schedule getScheduleById(String scheduleId);
    public void addNewSchedule(Schedule schedule);
    public void deleteSchedule(String scheduleId);
}
