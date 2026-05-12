package se.yrgo.client;

import se.yrgo.services.employees.EmployeeService;

import java.util.Scanner;

public class EmployeeMenu {
    private EmployeeService employeeService;
    Scanner scanner = new Scanner(System.in);

    public EmployeeMenu(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void showEmployeeMainMenu() {
        System.out.println("Select action:\n1. Manage employees\n2. Manage schedules\n3. Exit");
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

            System.out.println("Select action:\1. Manage employees\n2. Manage schedules\n3. Exit");
            choice = scanner.nextLine();
        }

        scanner.close();
    }

    public void showEmployeeManagementMenu() {
        System.out.println("Select action in Employee Management:" +
                "\n1. Show all employees" +
                "\n2. Add new employee" +
                "\n3. Find employee by id" +
                "\n4. Update employee" +
                "\n5. Delete employee" +
                "\n6. Exit");

        String choice = scanner.nextLine();

    }

    public void showScheduleManagementMenu() {
        System.out.println("Select action in Schedule Management:" +
                "\n1. Show all schedules" +
                "\n2. Add new schedule" +
                "\n3. Find schedule by id" +
                "\n4. Find schedule by employee" +
                "\n5. Find schedule by table" +
                "\n6. Find schedule by date" +
                "\n7. Update schedule" +
                "\n8. Delete schedule" +
                "\n9. Exit");

        String choice = scanner.nextLine();

    }
}
