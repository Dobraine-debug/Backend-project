package se.yrgo.services.employees;

public class DublicatedEmployeeIdException extends RuntimeException {
    private static final long serialVersionUID = 5L;

    public DublicatedEmployeeIdException(){}

    public DublicatedEmployeeIdException(String message) {
        super(message);
    }

    public DublicatedEmployeeIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
