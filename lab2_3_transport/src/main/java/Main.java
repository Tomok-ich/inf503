package src.main.java;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TransportService service = new TransportService();
        List<Transport> transports = service.readAll();

        PrintService printService = new PrintService();

        System.out.println("Все транспортные средства:");
        for (Transport t : transports) {
            System.out.println(t);
        }

        System.out.println("Сортировка по парковому номеру (номер и время начала):");
        printService.printSortedByNumber(transports);

        System.out.println("Сортировка по номеру маршрута (маршрут, время начала-конца):");
        printService.printSortedByRouteNumber(transports);

        System.out.println("Количество разных маршрутов:");
        printService.printCountDistinctRoutes(transports);

        System.out.println("Количество разных транспортных средств:");
        printService.printCountDistinctVehicles(transports);

        System.out.println("Количество ТС на каждом маршруте:");
        printService.printRouteCounts(transports);

        Map<TransportType, List<Transport>> grouped = service.readAllGroupedByType();
        System.out.println("Транспорт по типам:");
        for (Map.Entry<TransportType, List<Transport>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue().size() + " шт.");
        }
    }
}