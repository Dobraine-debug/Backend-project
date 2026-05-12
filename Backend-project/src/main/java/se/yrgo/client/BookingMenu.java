package se.yrgo.client;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.RestaurantTable;
import se.yrgo.domains.Session;
import se.yrgo.services.bookings.BookingService;
import se.yrgo.services.customers.CustomerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingMenu {
    private BookingService bookingService;
    private Scanner scanner;
    private CustomerService service;

    public BookingMenu(BookingService bookingService, CustomerService service) {
        this.bookingService = bookingService;
        this.scanner = new Scanner(System.in);
        this.service = service;
    }


    public void open() {
        boolean showMenu = true;

        while (showMenu) {
            System.out.println("1. Show reservations\n" +
                    "2. Add new reservation\n" +
                    "3. Cancel reservation\n" +
                    "4. Find reservation\n" +
                    "5. Update reservation\n" +
                    "6. Back");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookingService.getAllReservations().forEach(System.out::println);
                    break;

                case "2":
                    System.out.println("Enter customer name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter customer ID (first 2 letters of first and last name, e.g. KALU):");
                    String customerID = scanner.nextLine();

                    System.out.println("Enter email:");
                    String email = scanner.nextLine();

                    System.out.println("Enter phone:");
                    String phone = scanner.nextLine();

                    System.out.println("Enter number of guests:");
                    int sizeOfParty = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter date (YYYY-MM-DD):");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    System.out.println("Enter session: ");
                    Session[] sessions = Session.values();

                    for (int i = 0; i < sessions.length; i++) {
                        System.out.println((i + 1) + ". " + sessions[i].getTime());
                    }
                    int choiceOfSession = Integer.parseInt(scanner.nextLine());
                    Session session = sessions[choiceOfSession - 1];

                    Customer customer = new Customer(customerID, name, email, phone);
                    service.newCustomer(customer);
                    List<RestaurantTable> availableTables = bookingService.getAvailableTables(session, date, sizeOfParty);

                    if (availableTables.isEmpty()) {
                        System.out.println("No available table.");
                        break;
                    }
                        System.out.println("Available tables:");
                        for (int i = 0; i < availableTables.size(); i++) {
                            System.out.println((i + 1) + ": " + availableTables.get(i));
                    }
                    System.out.println("Choose an available table:");
                        int tableChoice = Integer.parseInt(scanner.nextLine()) - 1;
                        RestaurantTable selectedTable = availableTables.get(tableChoice);

                    Reservation reservation = new Reservation(customer, selectedTable, session, date, sizeOfParty);
                    bookingService.createReservation(reservation);
                    break;

                case "3":
                    System.out.println("Enter customer ID (first 2 letters of first and last name, e.g. KALU):");
                    String customerId = scanner.nextLine();
                    List<Reservation> allReservationsByCustomer = bookingService.getReservationByCustomer(customerId);
                    for (Reservation r : allReservationsByCustomer) {
                        System.out.println(r);
                    }
                    break;

                case "4":
                    searchMenu();
                    break;

                case "5":


                case "6":
                    showMenu = false;
                    break;
            }
        }
    }

    private void searchMenu() {
        boolean searching = true;

        while (searching) {
            System.out.println(
                    "1. Find reservations by customer\n" +
                            "2. Find reservations by date\n" +
                            "3. Back"
            );

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter customer name:");
                    String name = scanner.nextLine();

                    bookingService.getReservationByCustomer(name).forEach(System.out::println);
                    break;

                case "2":
                    System.out.println("Enter date (YYYY-MM-DD");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    bookingService.getReservationsByDate(date).forEach(System.out::println);
                    break;

                case "3":
                    searching = false;
                    break;
            }
        }
    }
}
