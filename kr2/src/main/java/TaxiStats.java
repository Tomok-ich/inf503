import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxiStats {
    public static void main(String[] args) {
        // 1. Чтение файла в список строк
        List<String> lines = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("variant2_1.csv"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!line.isBlank()) lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
            return;
        }

        List<Trip> trips = lines.stream()
                .map(line -> parseTrip(line))
                .filter(obj -> obj != null)
                .collect(Collectors.toList());

        // 4. Создать и наполнить данными из файла структуру Map<Автомобиль(номер), кол-во поездок>
        Map<String, Integer> carRideCount = trips.stream()
                .collect(Collectors.toMap(
                        trip -> trip.getCarNumber(),
                        trip -> 1,
                        (a, b) -> a + b
                ));

        // 5. вывести все поездки в порядке возрастания времени начала поездки
        System.out.println("=== Поездки в порядке возрастания времени отправления ===");
        trips.stream()
                .sorted((t1, t2) -> t1.getDepartureTime().compareTo(t2.getDepartureTime()))
                .forEach(trip -> System.out.println(trip));

        // 6. подсчитать количество разных клиентов такси
        Set<String> uniqueClients = trips.stream()
                .map(trip -> trip.getClientPhone())
                .collect(Collectors.toSet());

        // 7. Прочитать текст из файла, подсчитать количество разных клиентов такси по определенному адресу
        String targetAddress = "Москва";
        Set<String> uniqueClientsAtAddress = trips.stream()
                .filter(trip -> trip.getDepartureAddress().equals(targetAddress))
                .map(trip -> trip.getClientPhone())
                .collect(Collectors.toSet());
        System.out.println("Количество разных клиентов, отправлявшихся из '" + targetAddress + "': " + uniqueClientsAtAddress.size());

        // 8. Прочитать текст из файла, найти количество разных адресов в базе данных
        Set<String> uniqueAddresses = trips.stream()
                .flatMap(trip -> Stream.of(trip.getDepartureAddress(), trip.getDestinationAddress()))
                .collect(Collectors.toSet());

        // 9. Прочитать текст из файла, найти количество разных автомобилей
        Set<String> uniqueCars = trips.stream()
                .map(trip -> trip.getCarNumber())
                .collect(Collectors.toSet());

        // 10. Прочитать текст из файла, найти количество разных водителей
        Set<String> uniqueDrivers = trips.stream()
                .map(trip -> trip.getDriverPhone())
                .collect(Collectors.toSet());

        // Вывод статистики
        System.out.println("=== Статистика ===");
        System.out.println("Количество разных клиентов: " + uniqueClients.size());
        System.out.println("Количество разных адресов: " + uniqueAddresses.size());
        System.out.println("Количество разных автомобилей: " + uniqueCars.size());
        System.out.println("Количество разных водителей: " + uniqueDrivers.size());
    }

    private static Trip parseTrip(String line) {
        String[] parts = line.split(";");
        if (parts.length < 9) {
            System.err.println("Пропущена некорректная строка: " + line);
            return null;
        }
        return new Trip(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                parts[7],
                parts[8]
        );
    }
}