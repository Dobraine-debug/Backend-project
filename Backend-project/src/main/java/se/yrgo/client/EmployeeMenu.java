package se.yrgo.client;

import se.yrgo.domains.Employee;
import se.yrgo.domains.RestaurantTable;
import se.yrgo.domains.Schedule;
import se.yrgo.services.bookings.BookingService;
import se.yrgo.services.bookings.TableNotFoundException;
import se.yrgo.services.employees.*;

import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
    private final EmployeeService employeeService;
    private final BookingService bookingService;
    Scanner scanner = new Scanner(System.in);

    public EmployeeMenu(EmployeeService employeeService, BookingService bookingService) {
        this.employeeService = employeeService;
        this.bookingService = bookingService;
    }

    public void showEmployeeMainMenu() {
        System.out.println("\nSelect action:\n1. Manage employees\n2. Manage schedules\n3. Exit to main menu");
        String choice = scanner.nextLine();

        while (!choice.equals("3")) {

            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("Select valid alternative");
            }

            if (choice.equals("1")) {
                showEmployeeManagementMenu();
            }

            if (choice.equals("2")) {
                showScheduleManagementMenu();
            }

            System.out.println("\nSelect action:\n1. Manage employees\n2. Manage schedules\n3. Exit to main menu");
            choice = scanner.nextLine();
        }
    }

    /**
     * Shows employee management system menu for the user
     */
    public void showEmployeeManagementMenu() {

        label:
        while (true) {
            System.out.println("\nSelect action in Employee Management:" +
                    "\n1. Show all employees" +
                    "\n2. Add new employee" +
                    "\n3. Find employee by id" +
                    "\n4. Update employee" +
                    "\n5. Delete employee" +
                    "\n6. Exit to Employee and Schedule management menu");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Employee> employeeList = employeeService.getAllEmployees();
                    for (Employee employee : employeeList) {
                        System.out.println(employee);
                    }
                    break;
                case "2":
                    addNewEmployee();
                    break;
                case "3":
                    findEmployeeById();
                    break;
                case "4":
                    updateEmployee();
                    break;
                case "5":
                    deleteEmployee();
                    break;
                case "6":
                    break label;
                default:
                    System.out.println("Select valid alternative");
                    break;
            }
        }
    }

    public void addNewEmployee() {
        System.out.println("Write employee's id: ");
        String id = scanner.nextLine();
        System.out.println("Write employee's name: ");
        String name = scanner.nextLine();
        System.out.println("Write employee's telephone: ");
        String telephone = scanner.nextLine();
        System.out.println("Write employee's email: ");
        String email = scanner.nextLine();

        Employee employee = new Employee(id, name, telephone, email);

        try {
            employeeService.saveEmployee(employee);
            System.out.println("New employee saved! " + employee);
        } catch (DublicatedEmployeeIdException e) {
            System.out.println("Employee with id " + id + " already exists");
        }
    }

    public void findEmployeeById() {
        try {
            System.out.println("Write employee's id: ");
            String id = scanner.nextLine();
            Employee employee = employeeService.findEmployeeById(id);
            System.out.println(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployee() {
        try {
            System.out.println("Write employee id for the employee you want to update: ");
            String id = scanner.nextLine();

            Employee employee = employeeService.findEmployeeById(id);

            System.out.println("Employee you want to update: " + employee);

            System.out.println("Write new name: ");
            employee.setName(scanner.nextLine());

            System.out.println("Write new telephone: ");
            employee.setTelephone(scanner.nextLine());

            System.out.println("Write new email: ");
            employee.setEmail(scanner.nextLine());

            // update in database
            employeeService.updateEmployee(employee);

            System.out.println("Employee updated. " + employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee() {
        try {
            System.out.println("Write employee's id: ");
            String id = scanner.nextLine();
            Employee employee = employeeService.findEmployeeById(id);
            employeeService.deleteEmployee(employee);
            System.out.println("Employee deleted");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Employee not found.");
        }
    }

    /**
     * Show schedule management menu for the user
     */
    public void showScheduleManagementMenu() {

        label:
        while (true) {
            System.out.println("\nSelect action in Schedule Management:" +
                    "\n1. Show all schedules" +
                    "\n2. Add new schedule" +
                    "\n3. Find schedule by id" +
                    "\n4. Find schedules by employee" +
                    "\n5. Find schedules by table" +
                    "\n6. Find schedules by date" +
                    "\n7. Update schedule" +
                    "\n8. Delete schedule" +
                    "\n9. Exit to Employee and Schedule management menu");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Schedule> scheduleList = employeeService.getAllSchedules();
                    for (Schedule schedule : scheduleList) {
                        System.out.println(schedule);
                    }
                    break;
                case "2":
                    addNewSchedule();
                    break;
                case "3":
                    findScheduleById();
                    break;
                case "4":
                    findSchedulesByEmployee();
                    break;
                case "5":
                    findSchedulesByTable();
                    break;
                case "6":
                    findSchedulesByDate();
                    break;
                case "7":
                    updateSchedule();
                    break;
                case "8":
                    deleteSchedule();
                    break;
                case "9":
                    break label;
                default:
                    System.out.println("Select valid alternative");
                    break;
            }
        }
    }

    public void addNewSchedule() {
        System.out.println("Write schedule's id: ");
        String scheduleId = scanner.nextLine();
        System.out.println("Write employee's id: ");
        String employeeId = scanner.nextLine();
        System.out.println("Write table id: ");
        String tableId = scanner.nextLine();
        System.out.println("Write date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        try {
            Employee employee = employeeService.findEmployeeById(employeeId);
            RestaurantTable table = bookingService.findTableById(tableId);
            Schedule schedule = new Schedule(scheduleId, employee, table, date);

            employeeService.saveSchedule(schedule);
            System.out.println("New schedule saved! " + schedule);

        } catch (EmployeeNotFoundException e) {
            System.out.println("Employee not found");

        } catch (TableNotFoundException e) {
            System.out.println("Table not found");
        } catch (DublicatedScheduleIdException e) {
            System.out.println("Schedule with id " + scheduleId + " already exists");
        }
    }

    public void findScheduleById() {
        try {
            System.out.println("Write schedule id: ");
            String id = scanner.nextLine();
            Schedule schedule = employeeService.findScheduleById(id);
            System.out.println(schedule);
        } catch (ScheduleNotFoundException e) {
            System.out.println("Schedule not found.");
        }
    }

    public void findSchedulesByEmployee() {
        System.out.println("Write employee id: ");
        String id = scanner.nextLine();
        List<Schedule> scheduleList = employeeService.findSchedulesByEmployee(id);

        for (Schedule schedule : scheduleList) {
            System.out.println(schedule);
        }
    }

    public void findSchedulesByTable() {
        System.out.println("Write table id: ");
        String id = scanner.nextLine();
        List<Schedule> scheduleList = employeeService.findSchedulesByTable(id);

        for (Schedule schedule : scheduleList) {
            System.out.println(schedule);
        }
    }

    public void findSchedulesByDate() {
        System.out.println("Write date: ");
        String date = scanner.nextLine();
        List<Schedule> scheduleList = employeeService.findSchedulesByDate(date);

        if (scheduleList.isEmpty()) {
            System.out.println("No schedules for the date " + date);
        } else {
            for (Schedule schedule : scheduleList) {
                System.out.println(schedule);
            }
        }
    }

    public void updateSchedule() {
        try {
            System.out.println("Write schedule id for the schedule you want to update: ");
            String id = scanner.nextLine();

            Schedule schedule = employeeService.findScheduleById(id);

            System.out.println("Schedule you want to update: " + schedule);

            // new employee
            System.out.println("Write new employee's id: ");
            String employeeId = scanner.nextLine();
            Employee employee = employeeService.findEmployeeById(employeeId);

            // new table
            System.out.println("Write new table's id: ");
            String tableId = scanner.nextLine();
            RestaurantTable table = bookingService.findTableById(tableId);

            // new date
            System.out.println("Write new date: ");
            String date = scanner.nextLine();

            schedule.setEmployee(employee);
            schedule.setTable(table);
            schedule.setDate(date);

            // update in database
            employeeService.updateSchedule(schedule);
            System.out.println("Schedule updated. " + schedule);

        } catch (ScheduleNotFoundException e) {
            System.out.println("Schedule not found");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Employee not found.");
        } catch (TableNotFoundException e) {
            System.out.println("Table not found");
        }
    }

    public void deleteSchedule() {
        try {
            System.out.println("Write schedule id: ");
            String id = scanner.nextLine();
            Schedule schedule = employeeService.findScheduleById(id);
            employeeService.deleteSchedule(schedule);
            System.out.println("Schedule deleted");
        } catch (ScheduleNotFoundException e) {
            System.out.println("Schedule not found.");
        }
    }
}
