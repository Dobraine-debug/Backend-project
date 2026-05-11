package se.yrgo.services.bookings;

public class TableNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3L;

    public TableNotFoundException() {}

    public TableNotFoundException(String message) {
        super(message);
    }

    public TableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}