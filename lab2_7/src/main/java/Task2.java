import java.io.*;

public class Task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("bookings.json"));

        String line;
        String longest = "";
        String shortest = null;

        while ((line = br.readLine()) != null) {

            if (shortest == null || line.length() < shortest.length()) {
                shortest = line;
            }

            if (line.length() > longest.length()) {
                longest = line;
            }
        }

        br.close();

        System.out.println("Самая длинная: " + longest);
        System.out.println("Самая короткая: " + shortest);
    }
}