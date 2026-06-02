package generator;

public class GeneratorState {
    private int max = 1000;
    private int currentValue = 0;

    public synchronized int getMax() {
        return max;
    }

    public synchronized void setMax(int max) {
        this.max = max;
    }

    public synchronized int getCurrentValue() {
        return currentValue;
    }

    public synchronized void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
