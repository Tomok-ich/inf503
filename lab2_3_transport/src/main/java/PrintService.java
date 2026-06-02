package src.main.java;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PrintService {

    class CompareByNumber implements Comparator<Transport> {
        @Override
        public int compare(Transport o1, Transport o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
    }

    public void printSortedByNumber(List<Transport> transports) {
        transports.sort(new CompareByNumber());
        for (Transport transport : transports) {
            System.out.println(transport.getNumber() + " " + transport.getWorkTimeBegin());
        }
    }

    public void printSortedByRouteNumber(List<Transport> transports) {
        transports.sort(new Comparator<Transport>() {
            public int compare(Transport o1, Transport o2) {
                return o1.getRouteNumber().compareTo(o2.getRouteNumber());
            }
        });
        for (Transport transport : transports) {
            System.out.println(transport.getRouteNumber() + " "
                    + transport.getWorkTimeBegin() + " - " + transport.getWorkTimeEnd());
        }
    }
    public void printCountDistinctRoutes(List<Transport> transports) {
        long distinctRoutes = transports.stream()
                .map(Transport::getRouteNumber)
                .distinct()
                .count();
        System.out.println("Количество разных маршрутов: " + distinctRoutes);
    }

    public void printCountDistinctVehicles(List<Transport> transports) {
        long distinctVehicles = transports.stream()
                .map(Transport::getNumber)
                .distinct()
                .count();
        System.out.println("Количество разных транспортных средств: " + distinctVehicles);
    }

    public void printRouteCounts(List<Transport> transports) {
        Map<String, Long> routeCounts = transports.stream()
                .collect(Collectors.groupingBy(Transport::getRouteNumber, Collectors.counting()));
        System.out.println("Маршрут : Количество ТС");
        routeCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}