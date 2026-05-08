package se.yrgo.services.bookings;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.Session;
import se.yrgo.domains.Table;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    public Reservation createReservation(Customer customer, Session session, Table table, LocalDate date);
    public List<Table> getAvailableTables(Session session, LocalDate date, int sizeOfParty);
    public Reservation updateReservation(Reservation reservation);
    public void cancelReservation(int id);

    public List<Reservation> getAllReservations();
    public List<Reservation> getReservationsByDate(LocalDate date);
    public List<Reservation> getReservationByCustomer(Customer customer);

}
