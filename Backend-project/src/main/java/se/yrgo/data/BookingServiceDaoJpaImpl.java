package se.yrgo.data;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.Table;
import se.yrgo.domains.TableStatus;

import java.time.LocalDate;
import java.util.List;

public class BookingServiceDaoJpaImpl implements BookingServiceDao {
    @Override
    public void createReservation(Reservation newReservation) {

    }

    @Override
    public void cancelReservation(int reservationId) {
    }

    @Override
    public void updateReservation(Reservation updatedReservation) {

    }

    @Override
    public List<Reservation> findAllReservations() {
        return List.of();
    }

    @Override
    public List<Reservation> findReservationByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Reservation> findByCustomer(Customer customer) {
        return List.of();
    }

    @Override
    public List<Table> findAllTables() {
        return List.of();
    }

    @Override
    public List<Table> findById(String tableId) {
        return List.of();
    }

    @Override
    public List<Table> findByStatus(TableStatus status) {
        return List.of();
    }
}
