package Homework;

public class IntegralCalculator {

    // Общая сумма для всех потоков
    private static double totalSum;
    // Объект-замок для синхронизации
    private static final Object lock = new Object();

    public static double f(double x) {
        return x * Math.exp(-2.0 * Math.PI * x);
    }

    // Последовательный подсчёт
    public static double integrateSequential(double a, double b, int N) {
        double h = (b - a) / N;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            double xi = a + h * i + h / 2.0;
            sum += f(xi);
        }
        return sum * h;
    }

    // Параллельный подсчёт с synchronized
    public static double integrateParallel(double a, double b, int N, int threadsCount) throws InterruptedException {
        double h = (b - a) / N;
        totalSum = 0.0;

        Thread[] threads = new Thread[threadsCount];
        int chunkSize = N / threadsCount;

        for (int t = 0; t < threadsCount; t++) {
            final int from = t * chunkSize;
            final int to = (t == threadsCount - 1) ? N : from + chunkSize;

            threads[t] = new Thread(() -> {
                // Каждый поток считает свою локальную сумму
                double localSum = 0.0;
                for (int i = from; i < to; i++) {
                    double xi = a + h * i + h / 2.0;
                    localSum += f(xi);
                }

                synchronized (lock) {
                    totalSum += localSum;
                }
            });

            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return totalSum * h;
    }

    public static void main(String[] args) throws InterruptedException {
        double a = 0.0;
        double b = 1.0;
        int N = 10_000_000;
        int threadsCount = 10;

        long t1 = System.nanoTime();
        double resultSeq = integrateSequential(a, b, N);
        long t2 = System.nanoTime();
        double timeSeq = (t2 - t1) / 1_000_000.0;
        System.out.println("Последовательно:");
        System.out.println("S = " + resultSeq + "           Время: " + timeSeq);

        long t3 = System.nanoTime();
        double resultPar = integrateParallel(a, b, N, threadsCount);
        long t4 = System.nanoTime();
        double timePar = (t4 - t3) / 1_000_000.0;
        System.out.println("Параллельно:");
        System.out.println("S = " + resultPar + "           Время: " + timePar);

        double diff = timeSeq - timePar;
        double speedup = timeSeq / timePar;

        System.out.println("\n Сравнение времени");
        System.out.println("Время последовательного: " + timeSeq);
        System.out.println("Время многопоточного: " + timePar);
        System.out.println("Разница: " + diff);
        System.out.println("Ускорение: " + speedup);
    }
}
