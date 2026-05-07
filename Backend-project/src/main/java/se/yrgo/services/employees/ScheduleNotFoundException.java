package se.yrgo.services.employees;

public class ScheduleNotFoundException extends Exception {
    private static final long serialVersionUID = 2L;

    public ScheduleNotFoundException() {
    }

    public ScheduleNotFoundException(String message) {
        super(message);
    }

    public ScheduleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
