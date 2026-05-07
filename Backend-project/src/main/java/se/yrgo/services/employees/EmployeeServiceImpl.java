package se.yrgo.services.employees;

import org.springframework.beans.factory.annotation.Autowired;
import se.yrgo.data.EmployeeServiceDao;
import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeServiceDao dao;

    @Override
    public List<Employee> showAllEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public void addNewEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(String employeeId) {

    }

    @Override
    public List<Schedule> showAllSchedules() {
        return List.of();
    }

    @Override
    public List<Schedule> showSchedulesForEmployeeId(String employeeId) {
        return List.of();
    }

    @Override
    public List<Schedule> showSchedulesForTable(String tableId) {
        return List.of();
    }

    @Override
    public Schedule getScheduleById(String scheduleId) {
        return null;
    }

    @Override
    public void addNewSchedule(Schedule schedule) {

    }

    @Override
    public void deleteSchedule(String scheduleId) {

    }
}
