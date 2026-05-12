package se.yrgo.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class BookingServiceDaoJpaImpl implements BookingServiceDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void createReservation(Reservation newReservation) {
        em.persist(newReservation);
    }

    @Override
    public void cancelReservation(int id) {
        Reservation reservation = em.find(Reservation.class, id);
        if (reservation != null) {
            em.remove(reservation);
        }
    }

    @Override
    public Reservation updateReservation(Reservation updatedReservation) {
        Reservation originalReservation = em.find(Reservation.class, updatedReservation.getId());

        if (originalReservation != null) {
            originalReservation.setDate(updatedReservation.getDate());
            originalReservation.setSession(updatedReservation.getSession());
            originalReservation.setTable(updatedReservation.getTable());
            originalReservation.setCustomer(updatedReservation.getCustomer());
            originalReservation.setSizeOfParty(updatedReservation.getSizeOfParty());
        }
        return originalReservation;
    }

    @Override
    public List<Reservation> findAllReservations() {
        return em.createQuery("select r from Reservation as r", Reservation.class).getResultList();
    }

    @Override
    public List<Reservation> findReservationByDate(LocalDate date) {
        return em.createQuery("select r from Reservation as r where r.date=:date", Reservation.class).setParameter("date", date).getResultList();
    }

    @Override
    public List<Reservation> findByCustomer(String name) {
        return em.createQuery("select r from Reservation as r where r.customer.name=:name", Reservation.class).setParameter("name", name).getResultList();
    }

    @Override
    public List<RestaurantTable> findAllTables() {
        return em.createQuery("select t from RestaurantTable as t", RestaurantTable.class).getResultList();
    }

    @Override
    public RestaurantTable findTableById(String tableId) {
        return em.createQuery("select t from RestaurantTable as t where t.tableId=:tableId", RestaurantTable.class).setParameter("tableId", tableId).getSingleResult();
    }

    @Override
    public List<RestaurantTable> findAvailableTables(LocalDate date, Session session, int sizeOfParty) {
        List<RestaurantTable> restaurantTables = em.createQuery("select t from RestaurantTable as t where t.numberOfSeats >=:sizeOfParty", RestaurantTable.class).setParameter("sizeOfParty", sizeOfParty).getResultList();
        List<RestaurantTable> availableRestaurantTables = new ArrayList<>();
        for (RestaurantTable restaurantTable : restaurantTables) {
            boolean isBooked = false;

            for (Reservation reservation : restaurantTable.getReservations()) {
                if (reservation.getDate().equals(date) && reservation.getSession() == session) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                availableRestaurantTables.add(restaurantTable);
            }
        }
        return availableRestaurantTables;
    }

    @Override
    public void createTable(RestaurantTable newRestaurantTable) {
        em.persist(newRestaurantTable);
    }

    @Override
    public void deleteAll() {
        List<RestaurantTable> allTables = findAllTables();
        for (RestaurantTable t : allTables) {
            em.remove(t);
        }

        List<Reservation> allReservations = findAllReservations();
        for (Reservation r : allReservations) {
            em.remove(r);
        }
    }
}
