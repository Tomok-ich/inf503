public class Task implements Runnable{

    private String message;

    public Task(String message) {
        super();
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.message.length(); i++) {
            System.out.print(message.charAt(i));
        }
        System.out.println();
    }
}
