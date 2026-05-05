package se.yrgo.domains;

public class Table {
    private int tableId;
    private int numberOfSeats;
    private TableStatus status;

    private Employee employee;
    private Reservation reservation;

    public Table(int tableId, int numberOfSeats) {
        this.tableId = tableId;
        this.numberOfSeats = numberOfSeats;
        this.status = TableStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == TableStatus.AVAILABLE;
    }

    public void assignReservation(Reservation reservation) {
        this.reservation = reservation;
        this.status = TableStatus.RESERVED;
    }

    public void freeTable() {
        this.reservation = null;
        this.status = TableStatus.AVAILABLE;
    }

    public void assignEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getTableId() { return tableId; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public TableStatus getStatus() { return status; }
    public Employee getEmployee() { return employee; }
    public Reservation getReservation() { return reservation; }

}
