package se.yrgo.services.bookings;

import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public Reservation createReservation(Customer customer, Session session, Table table, LocalDate date) {
        return null;
    }

    @Override
    public List<Table> getAvailableTables(Session session, LocalDate date, TableStatus status) {
        return List.of();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void cancelReservation(int id) {

    }

    @Override
    public List<Reservation> getAllReservations() {
        return List.of();
    }

    @Override
    public List<Reservation> getReservationsByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Reservation> getReservationByCustomer(Customer customer) {
        return List.of();
    }
}
