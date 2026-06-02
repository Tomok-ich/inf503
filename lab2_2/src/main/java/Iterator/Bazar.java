package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bazar implements Iterable<Fruit> {
    private Fruit[] fruits;

    public Bazar(String[] names) {
        fruits = new Fruit[names.length];
        for (int i = 0; i < names.length; i++) {
            fruits[i] = new Fruit(names[i]);
        }
    }

    @Override
    public Iterator<Fruit> iterator() {
        return new Iterator<Fruit>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < fruits.length;
            }

            @Override
            public Fruit next() {
                if (!hasNext()) throw new NoSuchElementException();
                return fruits[cursor++];
            }
        };
    }

    public static void main(String[] args) {
        Bazar bazar = new Bazar(new String[]{"Яблоко", "Груша", "Апельсин", "Лимон", "Гранат"});

        System.out.println("Первый проход:");
        for (Fruit f : bazar) {
            System.out.println(f);
        }

        System.out.println("Второй проход (работает корректно):");
        for (Fruit f : bazar) {
            System.out.println(f);
        }
    }
}