package se.yrgo.data;

import se.yrgo.domains.*;
import se.yrgo.services.bookings.BookingService;
import se.yrgo.services.customers.CustomerNotFoundException;
import se.yrgo.services.customers.CustomerService;
import se.yrgo.services.employees.EmployeeService;

public class SampleData {
    public void addData(CustomerService customer, EmployeeService employeeService, BookingService bookingService) throws CustomerNotFoundException {
        customer.deleteAll();
        employeeService.deleteAll();
        // bookingService.deleteAll();

        Customer customer1 = new Customer("C101", "David Skansholm",
                "david@skansholm.com", "0736-230384");
        Customer customer2 = new Customer("C102", "Erik Granqvist",
                "granqvist@gmail.com", "0735-190310");
        Customer customer3 = new Customer("C103", "Joel Fridh",
                "fridh@gmail.com", "0777-160952");
        Customer customer4 = new Customer("C104", "Hanna Haglund",
                "haglund@gmail.com", "0765-329218");
        Customer customer5 = new Customer("C105", "Josefina Runnquist",
                "runnquist@gmail.com", "0775-200986");
        Invoice invoice1 = new Invoice("I101", 300);
        Invoice invoice2 = new Invoice("I102", 250);
        Invoice invoice3 = new Invoice("I103", 400);
        Invoice invoice4 = new Invoice("I104", 600);
        Invoice invoice5 = new Invoice("I105", 750);
        Invoice invoice6 = new Invoice("I106", 150);
        customer.newCustomer(customer1);
        customer.newCustomer(customer2);
        customer.newCustomer(customer3);
        customer.newCustomer(customer4);
        customer.newCustomer(customer5);
        customer.addInvoice(invoice1, "C101");
        customer.addInvoice(invoice2, "C103");
        customer.addInvoice(invoice3, "C103");
        customer.addInvoice(invoice4, "C104");
        customer.addInvoice(invoice5, "C105");
        customer.addInvoice(invoice6, "C105");

        Employee employee1 = new Employee("E101", "Bengt Bengtsson", "09090909", "bosse@example.com");
        Employee employee2 = new Employee("E102", "Lars Larsson", "08080808", "lars@example.com");
        Employee employee3 = new Employee("E103", "Oskar Oskarsson", "07070707", "oskar@example.com");
        Employee employee4 = new Employee("E104", "Anders Andersson", "06060606", "anders@example.com");
        Employee employee5 = new Employee("E105", "Gustaf Gustafsson", "05050505", "gustaf@example.com");
        Employee employee6 = new Employee("E106", "Johan Johansson", "04040404", "johan@example.com");
        employeeService.saveEmployee(employee1);
        employeeService.saveEmployee(employee2);
        employeeService.saveEmployee(employee3);
        employeeService.saveEmployee(employee4);
        employeeService.saveEmployee(employee5);
        employeeService.saveEmployee(employee6);

        RestaurantTable table1 = new RestaurantTable("T101", 2);
        RestaurantTable table2 = new RestaurantTable("T102", 2);
        RestaurantTable table3 = new RestaurantTable("T103", 4);
        RestaurantTable table4 = new RestaurantTable("T104", 4);
        RestaurantTable table5 = new RestaurantTable("T105", 4);
        RestaurantTable table6 = new RestaurantTable("T106", 6);
        RestaurantTable table7 = new RestaurantTable("T107", 6);
        bookingService.createTable(table1);
        bookingService.createTable(table2);
        bookingService.createTable(table3);
        bookingService.createTable(table4);
        bookingService.createTable(table5);
        bookingService.createTable(table6);
        bookingService.createTable(table7);

        // Example schedules for 2026-05-12 & 2026-05-13
        Schedule schedule1 = new Schedule("S101", employee1, table1, "2026-05-12");
        Schedule schedule2 = new Schedule("S102", employee1, table2, "2026-05-12");
        Schedule schedule3 = new Schedule("S103", employee2, table3, "2026-05-12");
        Schedule schedule4 = new Schedule("S104", employee2, table4, "2026-05-12");
        Schedule schedule5 = new Schedule("S105", employee3, table5, "2026-05-12");
        Schedule schedule6 = new Schedule("S106", employee3, table6, "2026-05-12");
        Schedule schedule7 = new Schedule("S107", employee3, table7, "2026-05-12");

        Schedule schedule8 = new Schedule("S108", employee4, table1, "2026-05-13");
        Schedule schedule9 = new Schedule("S109", employee4, table2, "2026-05-13");
        Schedule schedule10 = new Schedule("S110", employee5, table3, "2026-05-13");
        Schedule schedule11 = new Schedule("S111", employee5, table4, "2026-05-13");
        Schedule schedule12 = new Schedule("S112", employee6, table5, "2026-05-13");
        Schedule schedule13 = new Schedule("S113", employee6, table6, "2026-05-13");
        Schedule schedule14 = new Schedule("S114", employee6, table7, "2026-05-13");
        employeeService.saveSchedule(schedule1);
        employeeService.saveSchedule(schedule2);
        employeeService.saveSchedule(schedule3);
        employeeService.saveSchedule(schedule4);
        employeeService.saveSchedule(schedule5);
        employeeService.saveSchedule(schedule6);
        employeeService.saveSchedule(schedule7);
        employeeService.saveSchedule(schedule8);
        employeeService.saveSchedule(schedule9);
        employeeService.saveSchedule(schedule10);
        employeeService.saveSchedule(schedule11);
        employeeService.saveSchedule(schedule12);
        employeeService.saveSchedule(schedule13);
        employeeService.saveSchedule(schedule14);
    }
}
