/*
    Создание класса предназначенного для выполнения в отдельном потоке
 */

public class TaskThread extends Thread {

    private String message;

    public TaskThread(String message) {
        super();
        this.message = message;
    }

    @Override
    // метод для запуска отдельного потока
    public void run() {
        for (int i = 0; i < this.message.length(); i++) {
            System.out.print(message.charAt(i));
        }
        System.out.println();
    }
}
