package src.main.java;

public abstract class Transport {
    protected TransportType type;
    protected String number;
    protected String routeNumber;
    protected String workTimeBegin;
    protected String workTimeEnd;

    public Transport(TransportType type, String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.type = type;
        this.number = number;
        this.routeNumber = routeNumber;
        this.workTimeBegin = workTimeBegin;
        this.workTimeEnd = workTimeEnd;
    }

    protected Transport() {
    }

    public TransportType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    public String toString() {
        return type.getName() + ": " + number + ", Маршрут " +
                routeNumber + ", Начало работы: " +
                workTimeBegin + ", Конец работы: " +
                workTimeEnd;
    }

}