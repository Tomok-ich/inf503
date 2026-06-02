package generator;

public class NumberGeneratorTask implements Runnable {

    private final GeneratorState state;

    public NumberGeneratorTask(GeneratorState state) {
        this.state = state;
    }

    @Override
    public void run() {
        int counter = 0;
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (state) {
                int currentMax = state.getMax();
                if (counter >= currentMax) {
                    counter = 0;
                } else {
                    counter++;
                }
                state.setCurrentValue(counter);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}