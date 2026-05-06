package se.yrgo.domains;

public enum Session {
    FIRST_SESSION("16:00 - 18:00"),
    SECOND_SESSION("18:00 - 20:00"),
    THIRD_SESSION("20:00 - 22:00");

    private final String time;

    Session(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
