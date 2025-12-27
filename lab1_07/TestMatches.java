import java.util.regex.Pattern;

public class TestMatches {
    public static void main(String[] args) {
        String EMAIL_PATTERN = "^[a-zA-Z\\d\\-_]+@[a-zA-Z\\d\\-_]+\\.[a-z]{2,}";
        System.out.println(Pattern.matches("^П.{2}", "Пии"));
        System.out.println(Pattern.matches(EMAIL_PATTERN, "ya@mail.ru"));
        // Определить сигнатуру
        // Деление на подзадачи (функции)
    }
}