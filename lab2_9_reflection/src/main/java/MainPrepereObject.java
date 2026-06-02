import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainPrepereObject {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Game game = new Game("Gamer");

        // 1. Определим к какому типу относится объект
        System.out.println("1. -------------------------------------");
        System.out.println(game.getClass());
        Class clazz = game.getClass();
        System.out.println(clazz.equals(Game.class));

        // 2. Публичные члены класса
        System.out.println("2. -------------------------------------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 3. Все члены класса
        System.out.println("3. -------------------------------------");
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            // Разрешаем сами себе доступ к значениям приватных членов
            field.setAccessible(true);
            System.out.println(field.getType() + " : " + field.getName()
                    + " = " + field.get(game) );
        }

        // 3' получаем значения членов класса через геттеры
        System.out.println("3'. -------------------------------------");
        allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            // 1) ищем для члена класса его геттер
            String getterName = "get" + field.getName().substring(0,1).toUpperCase()
                    + field.getName().substring(1);
            Method getter = clazz.getMethod(getterName);
            // 2) вызываем геттер, получаем значение
            Object value  = getter.invoke(game);

            System.out.println(field.getType() + " : " + field.getName()
                    + " = " + value );
        }


        // 4. Предки
        System.out.println("4. -------------------------------------");
        System.out.println(clazz.getSuperclass());

        // 5. Реализуемые интерфейсы
        System.out.println("5. -------------------------------------");
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        // 6. Публичные методы
        System.out.println("6. -------------------------------------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 7. Все методы
        System.out.println("7. -------------------------------------");
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
        }

    }
}