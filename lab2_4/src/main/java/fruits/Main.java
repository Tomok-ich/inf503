package fruits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        /*

        func(cb) - в Java такое незя
        Придумали функциональные интерфейсы
        Самостоятельная работа по функциональным интерфейсам

        Consumer - потребитель
        Predicate - предикат (сравнение) -> boolean
        Function - функция
        Supplier - поставщик -> T
        Comparator - сравнитель -> int

        Сортировка слиянием - всегда будет проходиться nlogn даже при отсортированном массиве (плохо)
        */

        Function<Object, Object> objectObjectFunction = (Object obj) -> new Object();
        List<Fruit> fruits = new ArrayList<>();
        fruits.addAll(List.of(
                new Fruit("Банан", 100),
                new Fruit("Апельсин", 120),
                new Fruit("Яблоко", 110),
                new Fruit("Мандарин", 200),
                new Fruit("Виноград", 250),
                new Fruit("Груша", 220)
        ));

        fruits.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        fruits.sort((Fruit a, Fruit b) -> a.getPrice() - b.getPrice());
        fruits.sort(new FruitComparator());
        fruits.forEach(new FruitConsumer());
        fruits.forEach(new Consumer<Fruit>() {
            @Override
            public void accept(Fruit fruit) {
                System.out.println("Name: " + fruit.getName());
            }
        });
    }
}