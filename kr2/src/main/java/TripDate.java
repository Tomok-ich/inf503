public class TripDate implements Comparable<TripDate> {
    private final String dateTimeStr;

    public TripDate(String dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    @Override
    public int compareTo(TripDate other) {
        return this.dateTimeStr.compareTo(other.dateTimeStr);
    }

    @Override
    public String toString() {
        return dateTimeStr;
    }
}