package se.yrgo.data;

import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceDao {
    public void createReservation(Reservation newReservation);
    public void cancelReservation(Reservation reservationToCancel);
    public void updateReservation(Reservation updatedReservation);

    public List<Reservation> findAllReservations();
    public List<Reservation> findReservationByDate(LocalDate date);
    public List<Reservation> findByCustomer(String name);

    public List<Table> findAllTables();
    public Table findTableById(String tableId);
    public List<Table> findAvailableTables(LocalDate date, Session session);
}
