package generics;

public class TestListPerson {
    public static void main(String[] args) {

        List503<Person> list = new ArrayList503<>();
        System.out.println("1. Новый список пуст? " + list.isEmpty());
        System.out.println("Размер: " + list.size());


        Person p1 = new Person("Alice", Gender.FEMALE);
        Person p2 = new Person("Bob", Gender.MALE);
        Person p3 = new Person("Charlie", Gender.MALE);
        Person p4 = new Person("Diana", Gender.FEMALE);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println("2. После добавления трёх элементов:");
        printList(list);
        System.out.println("Размер: " + list.size());
        System.out.println("Пуст? " + list.isEmpty());


        System.out.println("3. Содержит Alice? " + list.contains(p1));
        System.out.println("Содержит нового Person с именем Bob (мужчина)? "
                + list.contains(new Person("Bob", Gender.MALE)));


        System.out.println("4. Вставка в позицию index=2 (между Bob и Charlie):");
        list.add(2, p4);
        printList(list);

        try {
            list.add(0, new Person("Invalid", Gender.MALE));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ожидаемое исключение при вставке в index=0: " + e.getMessage());
        }

        try {
            list.add(5, new Person("Invalid", Gender.FEMALE));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение при вставке в index=5 (size=4): " + e.getMessage());
        }

        System.out.println("5. Элемент с индексом 1: " + list.get(1));
        try {
            list.get(4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ожидаемое исключение при get(4): " + e.getMessage());
        }

        Person removed = list.remove(0);
        System.out.println("6. Удалён элемент с индексом 0: " + removed);
        System.out.println("Список после удаления:");
        printList(list);

        Object[] array = list.toArray();
        System.out.println("7. Массив из списка:");
        for (Object obj : array) {
            System.out.println("   " + obj);
        }

        list.clear();
        System.out.println("8. Размер после очистки: " + list.size());
        System.out.println("Пуст? " + list.isEmpty());

        list.add(p2);
        list.add(p3);
        System.out.println("9. После повторного добавления Bob и Charlie:");
        printList(list);

    }

    private static void printList(List503<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("   [" + i + "] = " + list.get(i));
        }
    }
}