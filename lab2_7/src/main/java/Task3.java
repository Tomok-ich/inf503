import java.io.*;

public class Task3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("bookings.json"), "UTF-8")
        );

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("bookings_cp1251.json"), "Cp1251")
        );

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Файл создан в cp1251");
    }
}