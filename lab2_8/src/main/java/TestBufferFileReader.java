import java.io.*;

public class TestBufferFileReader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bookings.json"));

            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
