import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    private static int totalChars = 0;

    public static void main(String[] args) {

        try (
                InputStream is = new FileInputStream("messages.txt");
                InfiniteMessageReader reader = new InfiniteMessageReader(is);
                BufferedReader br = new BufferedReader(reader);

                BufferedWriter logWriter = new BufferedWriter(
                        new FileWriter("log.txt", true)
                );

                Scanner scanner = new Scanner(System.in)
        ) {

            while (true) {
                String line = br.readLine();

                if (line == null) break;

                System.out.println(line);

                logWriter.write(line);
                logWriter.newLine();
                logWriter.flush();

                totalChars += line.length();

                System.out.print("продолжить или завершить? ");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("завершить")) {
                    reader.close();
                    break;
                }
            }

            try (Writer statWriter = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("stat.txt"),
                            Charset.forName("Cp1251")
                    )
            )) {
                writeStat(statWriter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStat(Writer writer) throws IOException {
        writer.write("Количество обработанных символов: " + totalChars);
    }
}