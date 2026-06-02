public class MainTask {
    // Другой сопосб создания потоков
    public static void main(String[] args) throws InterruptedException {
        // Оценим возможности нашей вычислительной системы

        int countPoc = Runtime.getRuntime().availableProcessors();
        System.out.println(countPoc); // Количество виртуальных ядер

        Object mutex = new Object();

        Thread task1 = new Thread(new Task("Сообщение для потока 1"));
        Thread task2 = new Thread(new Task("Сообщение для потока 2"));
        Thread task3 = new Thread(new Task("Сообщение для потока 3")); // Можн было так Thread task3 = new Thread(new Task1("Сообщение для потока 3",mutex));

        // Запуск задач параллельных потоков
        task1.start();
        task2.start();
        task3.start();

        // Строка выполнется сразу не дожидаясь завершения работы всех потоков
        System.out.println("Зпустили 3 парллельные задачи");

        // Ожидаем завершение задачи 1
        task1.join();
        // Ожидаем завершение задачи 2
        task2.join();
        // Ожидаем завершение задачи 3
        task3.join();

        System.out.println("Все задачи выполнены");
    }
}
