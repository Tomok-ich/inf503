/*
public class MainTask {
    public static void main(String[] args) {
        // оценим возможности компика(колво виртуальных ядер)

        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Count" + countProc);

        // создадим несколько экземпляров задач
        Thread tsk1 = new Thread(new Task("taskThread"));
        Thread tsk2 = new Thread(new Task("taskThread"));
        Thread tsk3 = new Thread("taskThread");

        // запуск задач в параллельных потоках

        tsk1.start();
        tsk2.start();
        tsk3.start();

           Следующая строка начнет выполн

        System.out.println("Запустили 3 параллельные задачи");

        tsk1.join();
        tsk2.join();
        tsk3.join();

        System.out.println("Done it");
    }
}
*/