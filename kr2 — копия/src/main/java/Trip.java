public class Trip {
    private final String clientPhone;
    private final String clientName;
    private final String carNumber;
    private final String driverPhone;
    private final String driverName;
    private final String departureAddress;
    private final String destinationAddress;
    private final TripDate departureTime;
    private final TripDate arrivalTime;

    public Trip(String clientPhone, String clientName, String carNumber,
                String driverPhone, String driverName,
                String departureAddress, String destinationAddress,
                String departureTimeStr, String arrivalTimeStr) {
        this.clientPhone = clientPhone;
        this.clientName = clientName;
        this.carNumber = carNumber;
        this.driverPhone = driverPhone;
        this.driverName = driverName;
        this.departureAddress = departureAddress;
        this.destinationAddress = destinationAddress;
        this.departureTime = new TripDate(departureTimeStr);
        this.arrivalTime = new TripDate(arrivalTimeStr);
    }

    public String getCarNumber() {
        return carNumber;
    }

    public TripDate getDepartureTime() {
        return departureTime;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public String getDepartureAddress() {
        return departureAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s",
                clientPhone, clientName, carNumber, driverPhone, driverName,
                departureAddress, destinationAddress, departureTime, arrivalTime);
    }
}
