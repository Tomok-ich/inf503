public class Main {
    public static void main(String[] args) throws InterruptedException {

        // оценим возможности компика(колво виртуальных ядер)

        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Count" + countProc);

        // создадим несколько экземпляров задач
        TaskThread tsk1 = new TaskThread("taskThread");
        TaskThread tsk2 = new TaskThread("taskThread");
        TaskThread tsk3 = new TaskThread("taskThread");

        // запуск задач в параллельных потоках

        tsk1.start();
        tsk2.start();
        tsk3.start();
        /*
           Следующая строка начнет выполн
         */
        System.out.println("Запустили 3 параллельные задачи");

        tsk1.join();
        tsk2.join();
        tsk3.join();

        System.out.println("Done it");
    }
}
