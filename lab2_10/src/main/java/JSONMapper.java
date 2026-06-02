import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JSONMapper {

    public String writeObject(Object o) throws Exception {

        StringBuilder json = new StringBuilder();
        Class<?> clazz = o.getClass();
        json.append("{");
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Transient.class)) {
                continue;
            }
            Object value;
            if (field.isAnnotationPresent(PrintByGetter.class)) {
                String getterName =
                        "get" +
                                field.getName()
                                        .substring(0, 1)
                                        .toUpperCase()
                                +
                                field.getName()
                                        .substring(1);
                Method getter =
                        clazz.getMethod(getterName);
                value = getter.invoke(o);
            } else {
                value = field.get(o);
            }
            if (value == null) {
                PrintNullValueAs annotation =
                        field.getAnnotation(
                                PrintNullValueAs.class
                        );
                if (annotation != null) {
                    value = annotation.value();
                } else {
                    value = "null";
                }
                value = "\"" + value + "\"";
            }
            else if (value instanceof String) {
                value = "\"" + value + "\"";
            }
            if (!first) {
                json.append(",");
            }
            first = false;
            json.append("\n  \"")
                    .append(field.getName())
                    .append("\": ")
                    .append(value);
        }
        json.append("\n}");
        return json.toString();
    }
}