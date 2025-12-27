import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String RGB_LIMIT = "(([0-9])|([1-9][0-9])|(1[0-9]{2}|(2[0-4][0-9])|(25[0-5])))";
        String RGB_PATTERN = "(^rgb\\s*\\(\\s*" + RGB_LIMIT + "\\s*,\\s*" + RGB_LIMIT + "\\s*,\\s*" + RGB_LIMIT + "\\s*\\))|(#[a-zA-Z0-9]{6})";
        System.out.println(Pattern.matches(RGB_PATTERN, "rgb(25, 1, 0)"));
        System.out.println(Pattern.matches(RGB_PATTERN, "rgb (123, 321, 0)"));
        System.out.println(Pattern.matches(RGB_PATTERN, "#000000"));

    }
}