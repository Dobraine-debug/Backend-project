package se.yrgo.mock;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.RestaurantTable;
import se.yrgo.domains.Session;
import se.yrgo.services.bookings.BookingService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingServiceMockImpl implements BookingService {

    private List<RestaurantTable> mockTables = new ArrayList<>();
    private List<Customer> mockCustomers = new ArrayList<>();
    private List<Reservation> mockReservations = new ArrayList<>();

    public BookingServiceMockImpl() {
        RestaurantTable table1 = new RestaurantTable("Table 1", 4);
        RestaurantTable table2 = new RestaurantTable("Table 2", 8);
        RestaurantTable table3 = new RestaurantTable("Table 3", 2);

        mockTables.add(table2);
        mockTables.add(table3);
        findTableById("Table 4");

        Customer customer1 = new Customer("PK", "Pelle Karlsson", "pelle@mail.com", "070-1");
        Customer customer2 = new Customer("AB", "Anita Berglund", "anita@mail.com", "070-2");
        Customer customer3 = new Customer("MZ", "Monica Zetterlund", "monica@mail.com", "070-3");

        Reservation reservation1 = new Reservation(customer1, table1, Session.FIRST_SESSION, LocalDate.now(), 3);
        mockReservations.add(reservation1);
    }

    @Override
    public void createTable(RestaurantTable newRestaurantTable) {
        mockTables.add(newRestaurantTable);
        System.out.println("New table added: " + newRestaurantTable);

    }

    @Override
    public RestaurantTable findTableById(String tableId) {
        return new RestaurantTable("Table 4", 2);
    }

    @Override
    public void createReservation(Reservation newReservation) {
        mockReservations.add(newReservation);
        System.out.println("New reservation added: " + newReservation);
    }

    @Override
    public List<RestaurantTable> getAvailableTables(Session session, LocalDate date, int sizeOfParty) {
        List<RestaurantTable> availableTables = new ArrayList<>();
        for (RestaurantTable t : mockTables) {
            boolean booked = false;

            for (Reservation r : mockReservations) {
                if (r.getTable().equals(t)
                        && r.getDate().equals(date)
                        && r.getSession() == session) {
                    booked = true;
                    break;
                }
            }
            if (!booked && t.getNumberOfSeats() >= sizeOfParty) {
                availableTables.add(t);
            }
        }
        System.out.println("Available tables: ");
        for (RestaurantTable t : availableTables) {
            System.out.println("\n" + t);
        }
        return availableTables;
    }

    @Override
    public Reservation updateReservation(Reservation updatedReservation) {
        for (Reservation r : mockReservations) {
            if (r.getReservationId() == updatedReservation.getReservationId() || r.getCustomer().getName().equals(updatedReservation.getCustomer().getName())) {
                r.setCustomer(updatedReservation.getCustomer());
                r.setSession(updatedReservation.getSession());
                r.setDate(updatedReservation.getDate());
                r.setReservationId(updatedReservation.getReservationId());
                r.setSizeOfParty(updatedReservation.getSizeOfParty());

            }
        }
        System.out.println(
                "Updated reservation: " + updatedReservation +
                        "\nCustomer: " + updatedReservation.getCustomer() +
                        "\nSession: " + updatedReservation.getSession() +
                        "\nDate: " + updatedReservation.getDate() +
                        "\nReservation ID: " + updatedReservation.getReservationId() +
                        "\nSize of party: " + updatedReservation.getSizeOfParty());
        return updatedReservation;
    }

    @Override
    public void cancelReservation(int id) {
        Reservation reservationToCancel = null;
        for (Reservation r : mockReservations) {
            reservationToCancel = r;
            break;
        } if (reservationToCancel != null) {
        mockReservations.remove(reservationToCancel);
        System.out.println(
                "Removed reservation:" +
                        "\nID: " + reservationToCancel.getReservationId() +
                        "\nDate: " + reservationToCancel.getDate() +
                        "\nCustomer: " + reservationToCancel.getCustomer());
        } else {
            System.out.println("No reservation with ID " + id + " found.");
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        System.out.println("All reservations: ");
        return mockReservations;
    }

    @Override
    public List<Reservation> getReservationsByDate(LocalDate date) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : mockReservations) {
            if (r.getDate().equals(date)) {
                result.add(r);
            }
        }
        System.out.println("Get reservations by date: ");
        return result;
    }

    @Override
    public List<Reservation> getReservationByCustomer(String name) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : mockReservations) {
            if (r.getCustomer().getName().equalsIgnoreCase(name)) {
                result.add(r);
            }
        }
        System.out.println("Get reservations by customer name: ");
        return result;
    }

    @Override
    public void deleteAll() {
        List<Reservation> allReservations = getAllReservations();
        for (Reservation r : allReservations) {
            System.out.println("delete r");
        }
    }
}
