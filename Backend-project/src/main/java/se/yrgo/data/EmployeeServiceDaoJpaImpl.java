package se.yrgo.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.yrgo.domains.Employee;
import se.yrgo.domains.Schedule;
import se.yrgo.domains.RestaurantTable;
import se.yrgo.services.bookings.TableNotFoundException;
import se.yrgo.services.employees.EmployeeNotFoundException;
import se.yrgo.services.employees.ScheduleNotFoundException;

import java.util.List;

/**
 * Implementation for employee and schedule by using JPA. Handles CRUD-operations and other queries for Employee
 * and Schedule entities.
 */
@Repository
public class EmployeeServiceDaoJpaImpl implements EmployeeServiceDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> getAllEmployees() {
        return em.createQuery("select employee from Employee as employee").getResultList();
    }

    @Override
    public Employee getEmployeeById(String employeeId) throws EmployeeNotFoundException {
        try {
            return (Employee) em.createQuery("select employee from Employee as employee where employee.employeeId=:employeeId").setParameter("employeeId", employeeId).getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public void createEmployee(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employeeToUpdate) throws EmployeeNotFoundException {
        Employee employee = em.find(Employee.class, employeeToUpdate.getId());

        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        employee.setEmployeeId(employeeToUpdate.getEmployeeId());
        employee.setName(employeeToUpdate.getName());
        employee.setEmail(employeeToUpdate.getEmail());
        employee.setTelephone(employeeToUpdate.getTelephone());
    }

    @Override
    public void deleteEmployee(Employee employeeToDelete) throws EmployeeNotFoundException {
        Employee employee = em.find(Employee.class, employeeToDelete.getId());

        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        em.remove(employee);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return em.createQuery("select schedule from Schedule as schedule").getResultList();
    }

    @Override
    public List<Schedule> getSchedulesByEmployee(String employeeId) {
        return em.createQuery("select schedule from Schedule as schedule where schedule.employee.employeeId=:employeeId")
                .setParameter("employeeId", employeeId)
                .getResultList();
    }

    @Override
    public List<Schedule> getSchedulesByTable(String tableId) {
        return em.createQuery("select schedule from Schedule as schedule where schedule.table.tableId=:tableId")
                .setParameter("tableId", tableId)
                .getResultList();
    }

    @Override
    public List<Schedule> getSchedulesByDate(String date) {
        return em.createQuery("select schedule from Schedule as schedule where schedule.date=:date")
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public Schedule getScheduleById(String scheduleId) throws ScheduleNotFoundException {
        try {
            return em.createQuery("select schedule from Schedule as schedule where schedule.scheduleId=:scheduleId", Schedule.class)
                    .setParameter("scheduleId", scheduleId)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            throw new ScheduleNotFoundException();
        }
    }

    /**
     * Creates a new schedule for table and employee. Checks first that both employee and table exist.
     * @param schedule
     * @throws TableNotFoundException
     * @throws EmployeeNotFoundException
     */
    @Override
    public void createSchedule(Schedule schedule) throws TableNotFoundException, EmployeeNotFoundException {
        RestaurantTable restaurantTable = em.find(RestaurantTable.class, schedule.getTable().getId());
        Employee employee = em.find(Employee.class, schedule.getEmployee().getId());

        if (employee == null) {
            throw new EmployeeNotFoundException();
        }

        if (restaurantTable == null) {
            throw new TableNotFoundException();
        }

        employee.addScheduleForEmployee(schedule);
        restaurantTable.addScheduleForTable(schedule);

        em.persist(schedule);
    }

    @Override
    public void updateSchedule(Schedule scheduleToUpdate) throws ScheduleNotFoundException {
        Schedule schedule = em.find(Schedule.class, scheduleToUpdate.getId());

        if (schedule == null) {
            throw new ScheduleNotFoundException();
        }

        schedule.setScheduleId(scheduleToUpdate.getScheduleId());
        schedule.setDate(scheduleToUpdate.getDate());
        schedule.setEmployee(scheduleToUpdate.getEmployee());
        schedule.setTable(scheduleToUpdate.getTable());
    }

    @Override
    public void deleteSchedule(Schedule scheduleToDelete) throws ScheduleNotFoundException {
        Schedule schedule = em.find(Schedule.class, scheduleToDelete.getId());

        if (schedule == null) {
            throw new ScheduleNotFoundException();
        }

        schedule.getEmployee().getEmployeeScheduleList().remove(schedule);
        schedule.getTable().getSchedules().remove(schedule);

        em.remove(schedule);
    }
}
