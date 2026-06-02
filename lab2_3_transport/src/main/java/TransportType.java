package src.main.java;

public enum TransportType {
    bus("Автобус"),
    tram("Трамвай"),
    trolleybus("Троллейбус");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}