import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        BookingsData data = mapper.readValue(new File("C:\\Informatika\\inf503\\bookings.json"), BookingsData.class);

        data.getBookings().forEach(b -> System.out.println(b));


        Long task1Male = data.getBookings().stream().filter(booking -> booking.getHotel().getId() == 150 && booking.getPerson().getGender().equals("Male")).count();
        Long task1Female = data.getBookings().stream().filter(booking -> booking.getHotel().getId() == 150 && booking.getPerson().getGender().equals("Female")).count();
        System.out.println(task1Male);
        System.out.println(task1Female);

        List<String> cities = data.getBookings().stream().map(booking -> booking.getPerson().getFromcity() + "]").distinct().sorted((o1, o2) -> o1.compareTo(o2)).toList();
        System.out.println(cities);

        Long bookingsDecember = data.getBookings().stream().filter(booking -> booking.getArrivaldate().matches("2021-12-[0-9]*")).count();
        System.out.println(bookingsDecember);

        Map<String, Integer> hotelBookingsCount = data.getBookings().stream().collect(Collectors.toMap(booking -> booking.getHotel().getName(), (booking) -> 1, (Integer v1, Integer v2) -> v1 + v2));
        System.out.println(hotelBookingsCount);

        Map<String, Integer> cityBookingsCount = data.getBookings().stream().collect(Collectors.toMap(booking -> booking.getPerson().getFromcity(), (booking) -> 1, (Integer v1, Integer v2) -> v1 + v2));
        System.out.println(cityBookingsCount);

        Long personsFromSaintPetersburg = data.getBookings().stream().filter(booking -> booking.getPerson().getFromcity().contains("Санкт-Петербург")).count();
        System.out.println(personsFromSaintPetersburg);


        // 7
        String idealHotel = data.getBookings().stream().filter(booking -> booking.getArrivaldate().matches("2022-01-[0-9]*")).collect(Collectors.toMap(booking -> booking.getHotel().getName(), booking -> 1, (Integer v1, Integer v2) -> v1 + v2)).entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get().getKey();

        System.out.println(idealHotel);

        // 8
        List<String> cities3545Mans = data.getBookings().stream().filter(booking -> booking.getPerson().getBirthdate() != null && booking.getPerson().getBirthdate().matches("(198[1-9]-03-21)|(199[0-1]-03-21)") && booking.getPerson().getGender() != null && booking.getPerson().getGender().equals("Male")).map(booking -> booking.getPerson().getFromcity()).toList();
        System.out.println(cities3545Mans);

        // 9
        List<String> childrens14Years = data.getBookings().stream().filter(booking -> booking.getPerson().getBirthdate() != null && booking.getArrivaldate() != null).filter(booking -> (Integer.valueOf(booking.getPerson().getBirthdate().split("-")[0]) - Integer.valueOf(booking.getArrivaldate().split("-")[0])) < 14).map(booking -> booking.getHotel().getName()).toList();
        System.out.println(childrens14Years);

        // 10
        List<Person> peoplesMore3Bookings = data.getBookings().stream().filter(booking -> booking.getPerson().getBirthdate() != null && booking.getArrivaldate() != null).collect(Collectors.toMap(booking -> booking.getPerson(), (booking) -> 1, (Integer v1, Integer v2) -> v1 + v2)).entrySet().stream().map(p -> p.getKey()).toList();
        System.out.println(peoplesMore3Bookings);


        /*11. Вывести гостиницы в которых проживали женщины из Санкт-Петербурга
        в период с февраля по март 2022 года (использовать несколько фильтров)*/

        List<String> hotelsFemalesSaintPetersburg2022 = data.getBookings().stream()
                .filter(booking ->
                        booking.getPerson().getGender() != null
                                && booking.getPerson().getGender().equals("Female")
                                && booking.getPerson().getFromcity().contains("Санкт-Петербург")
                                && booking.getStayingdate().matches("2022-02-[0-9]*")
                                && booking.getDeparturedate().matches("2022-03-[0-9]*")
                )
                .map(booking ->
                        booking.getHotel().getName()
                )
                .distinct()
                .toList();
        System.out.println(hotelsFemalesSaintPetersburg2022);
        /*12. вывести таблицу возрастная группа - количество броней
        (группы: 1 - 0-14, 2 - 15-18, 3 - 19-25, 4 - 26-35, 5 - 36-45, 6 - 45-...)*/
        Map<Integer, Integer> tableYearBookings = data.getBookings().stream()
                .filter(booking -> booking.getPerson().getBirthdate() != null)
                .collect(
                        Collectors.toMap(booking -> {
                                    int age = 2026 - Integer.parseInt(booking.getPerson().getBirthdate().split("-")[0]);
                                    if (age <= 14) {
                                        return 1;
                                    } else if (age <= 18) {
                                        return 2;
                                    } else if (age <= 25) {
                                        return 3;
                                    } else if (age <= 35) {
                                        return 4;
                                    } else if (age <= 45) {
                                        return 5;
                                    } else {
                                        return 6;
                                    }
                                },
                                (booking) -> 1,
                                Integer::sum
                        )
                );
        System.out.println(tableYearBookings);

    /*13. вывести список проживающих в гостинице с id=123,
     приехавших из Самарской области с апреля по май 2023г.*/

        List<Person> persons = data.getBookings().stream()
                .filter(booking ->
                        booking.getHotel().getId() == 123
                                && booking.getPerson().getFromcity().contains("Самарская область")
                                && booking.getStayingdate().matches("2022-0[4-5]-[0-9]*"))
                .map(Booking::getPerson)
                .toList();
        System.out.println(persons);
/*
        // 14. вывести таблицу - город, список гостиниц, принимающих гостей из этого города

        data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity() != null)
                .collect(Collectors.groupingBy(
                        b -> b.getHotel().getName()))

                .entrySet().stream()

                .forEach((key, value) -> {
                    System.out.println();
                    value.forEach((v) -> System.out.println(v));
             });

    }

 */
    }
}

/*

    Booking

  "bookings": [
    {
      "id": 7087959,
      "arrivaldate": "2022-03-10",
      "stayingdate": "2022-03-11",
      "departuredate": "2022-03-11",
      "hotel": {
        "id": 332,
        "name": "hotel332"
      },
      "person": {
        "gender": "Male",
        "birthdate": "1983-10-14",
        "fromcity": "Город Санкт-Петербург"
      }
    },
    ]
   Объектная модель
*/