package se.yrgo.services.bookings;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.yrgo.data.BookingServiceDao;
import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingServiceDao dao;

    @Override
    public void createTable(RestaurantTable newRestaurantTable) {
        dao.createTable(newRestaurantTable);
    }

    @Override
    public RestaurantTable findTableById(String tableId) {
        return dao.findTableById(tableId);
    }

    @Override
    public void createReservation(Reservation newReservation) {
        dao.createReservation(newReservation);
    }

    @Override
    public List<RestaurantTable> getAvailableTables(Session session, LocalDate date, int sizeOfParty) {
        return dao.findAvailableTables(date, session, sizeOfParty);
    }

    @Override
    public Reservation updateReservation(Reservation updatedReservation) {
        return dao.updateReservation(updatedReservation);
    }

    @Override
    public void cancelReservation(int id) {
        dao.cancelReservation(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return dao.findAllReservations();
    }

    @Override
    public List<Reservation> getReservationsByDate(LocalDate date) {
        return dao.findReservationByDate(date);
    }

    @Override
    public List<Reservation> getReservationByCustomer(String name) {
        return dao.findByCustomer(name);
    }

    public void deleteAll() {
        dao.deleteAll();
    }
}
