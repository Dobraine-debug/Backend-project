package se.yrgo.data.bookings;

import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceDao {
    public void createReservation(Reservation newReservation);
    public void cancelReservation(int id);
    public Reservation updateReservation(Reservation updatedReservation);

    public List<Reservation> findAllReservations();
    public List<Reservation> findReservationByDate(LocalDate date);
    public List<Reservation> findByCustomer(String name);

    public List<RestaurantTable> findAllTables();
    public RestaurantTable findTableById(String tableId);
    public List<RestaurantTable> findAvailableTables(LocalDate date, Session session, int sizeOfParty);

    void createTable(RestaurantTable newRestaurantTable);
    void deleteAll();
}
