package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /*
            lambda
        */
        Predicate<String> task1 = s -> s.startsWith("Муз");
        Function<Integer, String> task2 = num -> String.valueOf(num);
        Comparator<Person> task3 = (a, b) -> a.getHeight() - b.getHeight();
        Consumer<Person> task4 = p -> System.out.println(p.getName());


        List<Integer> task5 = new ArrayList<>();
        task5.sort((a, b) -> a - b);

        List<Integer> task6 = new ArrayList<>();
        task6.replaceAll(n -> n % 16);

        Student student = new Student("Rinat", "11-503", "16.01.2007");

        student.work((s, w) -> System.out.println(s + " " + w), "купица");

    }
}