import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonExporter {

    public static void export(DatabaseUtils db) throws Exception {

        List<String> objects = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Many m = db.findById(i);

            if (m != null) {
                objects.add(toJson(m));
            }
        }
        StringBuilder json = new StringBuilder();
        json.append("[\n");

        for (int i = 0; i < objects.size(); i++) {
            json.append(objects.get(i));

            if (i != objects.size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("]");

        try (FileWriter fw = new FileWriter("students.json")) {
            fw.write(json.toString());
        }
    }
    public static String toJson(Object obj) throws Exception {

        StringBuilder json = new StringBuilder();
        json.append("{\n");

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();

        boolean first = true;

        for (Field field : fields) {

            field.setAccessible(true);

            Object value = field.get(obj);

            if (!first) {
                json.append(",\n");
            }

            first = false;

            json.append("  \"")
                    .append(field.getName())
                    .append("\": ");

            if (value instanceof String || value instanceof java.util.Date) {
                json.append("\"")
                        .append(value)
                        .append("\"");
            } else {
                json.append(value);
            }
        }

        json.append("\n}");

        return json.toString();
    }
}