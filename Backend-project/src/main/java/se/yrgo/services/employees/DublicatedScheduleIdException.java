package se.yrgo.services.employees;

public class DublicatedScheduleIdException extends RuntimeException {
    private static final long serialVersionUID = 4L;

    public DublicatedScheduleIdException(){}

    public DublicatedScheduleIdException(String message) {
        super(message);
    }

    public DublicatedScheduleIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
