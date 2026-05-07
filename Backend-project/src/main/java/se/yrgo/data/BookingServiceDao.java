package se.yrgo.data;

import se.yrgo.domains.Customer;
import se.yrgo.domains.Reservation;
import se.yrgo.domains.Table;
import se.yrgo.domains.TableStatus;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceDao {
    public void createReservation(Reservation newReservation);
    public void cancelReservation(int reservationId);
    public void updateReservation(Reservation updatedReservation);

    public List<Reservation> findAllReservations();
    public List<Reservation> fintReservationByDate(LocalDate date);
    public List<Reservation> findByCustomer(Customer customer);

    public List<Table> findAllTables();
    public List<Table> findById(String tableId);
    public List<Table> findByStatus(TableStatus status);
}
