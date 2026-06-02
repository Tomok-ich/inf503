import java.lang.reflect.Field;

public class JSONMapper {

    public String writeObject(Object o) {

        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                String fieldName = field.getName();
                Object value = field.get(o);
                json.append("  \"")
                        .append(fieldName)
                        .append("\":\"")
                        .append(value)
                        .append("\"");
                if (i < fields.length - 1) {
                    json.append(",");
                }
                json.append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }
}