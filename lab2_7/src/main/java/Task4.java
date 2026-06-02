import java.io.*;

public class Task4 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("bookings.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("bookings_new.json"));

        String line;

        while ((line = br.readLine()) != null) {

            line = line.replace("arrivaldate", "arrivalDate");
            line = line.replace("stayingdate", "stayingDate");
            line = line.replace("departuredate", "departureDate");

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Файл с новыми ключами создан");
    }
}