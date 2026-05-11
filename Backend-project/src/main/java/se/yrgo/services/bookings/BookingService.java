package se.yrgo.services.bookings;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.Session;
import se.yrgo.domains.Table;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    public void createTable(Table newTable);
    public void createReservation(Reservation newReservation);
    public List<Table> getAvailableTables(Session session, LocalDate date, int sizeOfParty);
    public Reservation updateReservation(Reservation updatedReservation);
    public void cancelReservation(Reservation reservationToCancel);

    public List<Reservation> getAllReservations();
    public List<Reservation> getReservationsByDate(LocalDate date);
    public List<Reservation> getReservationByCustomer(String name);

}
