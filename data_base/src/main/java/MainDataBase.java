import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class MainDataBase {
    public static void main(String[] args) {

        DatabaseUtils db = new DatabaseUtils();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1 - Добавление в БД
                    2 - Поиск по ID
                    3 - Удаление по ID
                    4 - Изменение данных
                    5 - Вывод всех данных в файл students.html
                    6 - Вывод всех данных в JSON файл
                    0 - Выход
                    """);

            int cmd = Integer.parseInt(sc.nextLine());

            try {
                switch (cmd) {
                    case 1 -> add(db, sc);
                    case 2 -> find(db,sc);
                    case 3 -> delete(db,sc);
                    case 4 -> change(db,sc);
                    case 5 -> exportData(db);
                    case 6 -> exportJson(db);
                    case 0 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void add(DatabaseUtils db, Scanner sc) throws IOException {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Введите тип: 1 - доход, -1 расход");
        byte type = Byte.parseByte(sc.nextLine());

        System.out.println("Введите имя: ");
        String name = sc.nextLine();

        System.out.println("Введите сумму: ");
        float summ = Float.parseFloat(sc.nextLine());

        System.out.println("Введите комментарий: ");
        String comment = sc.nextLine();

        Many m = new Many(id, type, name, new Date(), summ, comment);
        db.save(m);
    }

    public static void find(DatabaseUtils db, Scanner sc) throws Exception {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Many findUser = db.findById(id);
        System.out.println(findUser);
    }

    public static void delete(DatabaseUtils db, Scanner sc) throws Exception {
        System.out.println("Введите ID: ");
        int id = Integer.parseInt(sc.nextLine());

        db.deleteById(id);
    }

    static void change(DatabaseUtils db, Scanner sc) throws Exception {
        System.out.println("id:");
        int id = Integer.parseInt(sc.nextLine());

        Many old = db.findById(id);
        if (old == null) {
            System.out.println("не найдено");
            return;
        }

        System.out.println("Новое имя:");
        old.setName(sc.nextLine());

        System.out.println("Новая сумма:");
        old.setSumm(Float.parseFloat(sc.nextLine()));

        System.out.println("Новый комментарий:");
        old.setComment(sc.nextLine());

        db.deleteById(id);
        db.save(old);
    }

    static void exportData(DatabaseUtils db) throws Exception {
        HtmlExporter.export(db);
        System.out.println("готово: students.html");
    }

    static void exportJson(DatabaseUtils db) throws Exception {
        JsonExporter.export(db);
        System.out.println("готово: students.json");
    }


}
