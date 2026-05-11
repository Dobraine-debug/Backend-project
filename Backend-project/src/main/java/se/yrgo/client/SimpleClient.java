package se.yrgo.client;


import jakarta.persistence.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Employee;
import se.yrgo.domains.Invoice;
import se.yrgo.domains.Schedule;
import se.yrgo.domains.Table;
import se.yrgo.services.bookings.BookingService;
import se.yrgo.services.customers.CustomerService;
import se.yrgo.services.employees.EmployeeNotFoundException;
import se.yrgo.services.employees.EmployeeService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class SimpleClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        try {


            EmployeeService employeeService = container.getBean(EmployeeService.class);
            BookingService bookingService = container.getBean(BookingService.class);

            // TEST: save two new employees
            employeeService.saveEmployee(new Employee("123acb", "Bosse", "0707070707", "bosse@example.com"));
            System.out.println("New employee saved!");

            employeeService.saveEmployee(new Employee("456efg", "Lisa", "09090909", "lisa@example.com"));
            System.out.println("new employee added");

            // TEST: get employee by id
            try {
                Employee employee = employeeService.findEmployeeById("123acb");
                Employee employee1 = employeeService.findEmployeeById("456efg");
                System.out.println("Found employee with id 123abc " + employee);
                System.out.println("Found employee with id 456efg " + employee1);
            } catch (EmployeeNotFoundException e) {
                System.err.println("Employee with id 123abc not found");
            }

            // TEST: get all employees
            List<Employee> allEmployees = employeeService.getAllEmployees();
            System.out.println("\nGetting all employees...");
            for (Employee e : allEmployees) {
                System.out.println(e);
            }

            // TEST: update an employee
            System.out.println("\nTEST: Update employee\nOld Bosse: " + employeeService.findEmployeeById("123acb") + "\n");

            Employee updatedEmployee = employeeService.findEmployeeById("123acb");
            updatedEmployee.setEmployeeId("999PPP");
            updatedEmployee.setName("New Bosse");
            updatedEmployee.setTelephone("10101010");
            updatedEmployee.setEmail("newBosse@example.com");

            try {
                employeeService.updateEmployee(updatedEmployee);
                System.out.println("New Bosse: " + employeeService.findEmployeeById("999PPP"));
            } catch (EmployeeNotFoundException e) {
                System.err.println("Could not find an employee with id 123acb");
            }

            // TEST: Delete an employee
            employeeService.saveEmployee(new Employee("TEMP", "Harry", "09090909", "temp@example.com"));
            Employee tempEmployee = employeeService.findEmployeeById("TEMP");
            System.out.println("Temp employee to be deleted: " + tempEmployee);

            // Getting all employees
            List<Employee> employeeList = employeeService.getAllEmployees();
            for (Employee e : employeeList) {
                System.out.println(e);
            }

            System.out.println("\nDeleting TEMP employee...");
            employeeService.deleteEmployee(tempEmployee);

            // Test that employee was deleted
            List<Employee> employeeList2 = employeeService.getAllEmployees();
            for (Employee e : employeeList2) {
                System.out.println(e);
            }

            Table table1 = new Table("111", 6);
            bookingService.createTable(table1);
            Table table2 = new Table("222", 4);
            bookingService.createTable(table2);

            employeeService.saveSchedule(new Schedule("555", updatedEmployee, table1, "2026-01-01"));
            Schedule schedule = employeeService.findScheduleById("555");
            System.out.println("Schedule with id 555: " + schedule);

            // TEST: get all schedules
            System.out.println("\nGetting all schedules...");
            List<Schedule> allSchedules = employeeService.getAllSchedules();
            for (Schedule s : allSchedules) {
                System.out.println(s);
            }



        } finally {
            container.close();
        }

    }
}