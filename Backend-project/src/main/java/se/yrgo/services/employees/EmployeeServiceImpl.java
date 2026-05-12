package se.yrgo.services.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.data.EmployeeServiceDao;
import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;
import se.yrgo.services.bookings.TableNotFoundException;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeServiceDao dao;

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public Employee findEmployeeById(String employeeId) throws EmployeeNotFoundException {
        return dao.getEmployeeById(employeeId);
    }

    @Override
    public void saveEmployee(Employee employee) {
        dao.createEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employeeToUpdate) throws EmployeeNotFoundException {
        dao.updateEmployee(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(Employee employeeToDelete) throws EmployeeNotFoundException {
        dao.deleteEmployee(employeeToDelete);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return dao.getAllSchedules();
    }

    @Override
    public List<Schedule> findSchedulesByEmployee(String employeeId) {
        return dao.getSchedulesByEmployee(employeeId);
    }

    @Override
    public List<Schedule> findSchedulesByTable(String tableId) {
        return dao.getSchedulesByTable(tableId);
    }

    @Override
    public List<Schedule> findSchedulesByDate(String date) {
        return dao.getSchedulesByDate(date);
    }

    @Override
    public Schedule findScheduleById(String scheduleId) throws ScheduleNotFoundException {
        return dao.getScheduleById(scheduleId);
    }

    @Override
    public void saveSchedule(Schedule schedule) throws TableNotFoundException, EmployeeNotFoundException {
        dao.createSchedule(schedule);
    }

    @Override
    public void updateSchedule(Schedule scheduleToUpdate) throws ScheduleNotFoundException {
        dao.updateSchedule(scheduleToUpdate);
    }

    @Override
    public void deleteSchedule(Schedule scheduleToDelete) throws ScheduleNotFoundException {
        dao.deleteSchedule(scheduleToDelete);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
