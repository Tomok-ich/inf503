import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileReader {
    public static void main(String[] args) {

        try{
            InputStream is = new FileInputStream("bookings.json");

            byte[] buffer = new byte[1024];

            int r;
            while((r = is.read(buffer)) != -1) {
                // строим стороку из массива, указываем какую его часть надо взять
                String str = new String(buffer, 0, r, "UTF-8");
                System.out.print((char) r);
            }

            is.close();
        } catch (FileNotFoundException err) {
            System.out.println("Файл не найден");
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
