import java.io.*;
import java.nio.file.*;

public class JsonBracketChecker {

    public static class NotTextFileException extends Exception {
        public NotTextFileException(String msg) {
            super(msg);
        }
    }

    public static int check(String fileName)
            throws IOException, NotTextFileException {

        if (fileName == null || fileName.isEmpty()) {
            throw new NullPointerException("Имя файла не должно быть пустым");
        }

        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл не найден: " + fileName);
        }

        byte[] bytes = Files.readAllBytes(file.toPath());
        String content = new String(bytes);

        // Проверка, что файл текстовый
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i] & 0xFF;
            if (b < 32 && b != '\n' && b != '\r' && b != '\t') {
                throw new NotTextFileException(
                        "Файл содержит нетекстовые символы на позиции " + (i + 1));
            }
        }

        // Проверка скобок через стек
        java.util.Deque<int[]> stack = new java.util.ArrayDeque<>();
        boolean insideString = false;
        boolean escaped = false;

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);

            if (escaped) {
                escaped = false;
                continue;
            }
            if (c == '\\' && insideString) {
                escaped = true;
                continue;
            }
            if (c == '"') {
                insideString = !insideString;
                continue;
            }
            if (insideString) continue;

            if (c == '{' || c == '[') {
                stack.push(new int[]{c, i + 1});
            } else if (c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return i + 1;
                }
                int[] top = stack.pop();
                char open = (char) top[0];
                if ((c == '}' && open != '{') || (c == ']' && open != '[')) {
                    return i + 1;
                }
            }
        }

        if (!stack.isEmpty()) {
            return stack.peekLast()[1];
        }

        return 0;
    }
}
