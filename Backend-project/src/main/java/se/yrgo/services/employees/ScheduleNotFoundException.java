package se.yrgo.services.employees;

public class ScheduleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2L;

    public ScheduleNotFoundException() {}

    public ScheduleNotFoundException(String message) {
        super(message);
    }

    public ScheduleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
