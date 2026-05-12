package se.yrgo.services.bookings;

import se.yrgo.domains.Reservation;
import se.yrgo.domains.Session;
import se.yrgo.domains.RestaurantTable;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    public void createTable(RestaurantTable newRestaurantTable);
    public void createReservation(Reservation newReservation);
    public List<RestaurantTable> getAvailableTables(Session session, LocalDate date, int sizeOfParty);
    public Reservation updateReservation(Reservation updatedReservation);
    public void cancelReservation(int id);

    public List<Reservation> getAllReservations();
    public List<Reservation> getReservationsByDate(LocalDate date);
    public List<Reservation> getReservationByCustomer(String name);

    void deleteAll();
}
