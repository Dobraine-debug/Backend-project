package se.yrgo.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.yrgo.domains.*;

import java.time.LocalDate;
import java.util.List;

public class BookingServiceDaoJpaImpl implements BookingServiceDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void createReservation(Reservation newReservation) {
        em.persist(newReservation);
    }

    @Override
    public void cancelReservation(Reservation reservationToCancel) {
        Reservation reservation = em.find(Reservation.class, reservationToCancel.getId());
        if (reservation != null) {
            em.remove(reservation);
        }
    }

    @Override
    public void updateReservation(Reservation updatedReservation) {
        Reservation originalReservation = em.find(Reservation.class, updatedReservation.getId());

        if (originalReservation != null) {
            originalReservation.setDate(updatedReservation.getDate());
            originalReservation.setSession(updatedReservation.getSession());
            originalReservation.setTable(updatedReservation.getTable());
            originalReservation.setCustomer(updatedReservation.getCustomer());
            originalReservation.setSizeOfParty(updatedReservation.getSizeOfParty());
        }
    }

    @Override
    public List<Reservation> findAllReservations() {
        return em.createQuery("select r from Reservation as r").getResultList();
    }

    @Override
    public List<Reservation> findReservationByDate(LocalDate date) {
        return em.createQuery("select r from Reservation as r where r.date=:date").getResultList();
    }

    @Override
    public List<Reservation> findByCustomer(String name) {
        return em.createQuery("select r from Reservation as r where r.customer.name=:name", Reservation.class).setParameter("name", name).getResultList();
    }

    @Override
    public List<Table> findAllTables() {
        return em.createQuery("select t from Table as t").getResultList();
    }

    @Override
    public Table findTableById(String tableId) {
        return em.createQuery("select t from Table as t where t.tableId=:tableId", Table.class).setParameter("tableId", tableId).getSingleResult();
    }

    @Override
    public List<Table> findAvailableTables(LocalDate date, Session session, int sizeOfParty) {
        return List.of();
    }


}
