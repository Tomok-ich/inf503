public class Task implements Runnable {

    private String message;
    //private Object mutex;

    public Task(String message) {
        // this.mutex = mutex;
        this.message = message;
    }

    // Метод запускаемый в отдельном потоке
    @Override
    public void run() {
        printf();
    }

    private void printf() {
        synchronized (Task.class) { // Этим блоком сможет управлять только один поток
            // Захватываем mutex
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
            }
            System.out.println();
            // Освобождение mutex
        }
    }
}
