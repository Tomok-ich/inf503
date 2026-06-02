import java.io.*;

public class Task1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("bookings.json"));

        int count = 0;
        while (br.readLine() != null) {
            count++;
        }

        br.close();
        System.out.println("Количество строк: " + count);
    }
}