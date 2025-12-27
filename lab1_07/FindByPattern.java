import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByPattern {
    public static void main(String[] args) {
        String work_str = "Hello Java! Hello JabaScript! JavaSE 8.";

        // String.substring(a, b) - возвращает подстроку начиная с индекса
        // а, и заканчивая (исключительно) b

        // Формируем шаблон, проводим предобработку (compile)
        Pattern pattern = Pattern.compile("[Jj].+?a");

        // Строим Matcher по строке с которой будем работать
        Matcher matcher = pattern.matcher(work_str);

        // Наличие фразы по шаблону
        int counter = 1;
        while (matcher.find()) {
            System.out.println(counter + ": (" +
                matcher.start() + ", " + matcher.end() + ") " +
                work_str.substring(matcher.start(), matcher.end()));
            counter++;
            //ColoredPrint.print(work_str, matcher.start(), matcher.end());
        }

    }
}