import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestUTFReader {
    public static void main(String[] args) {

        int  r = 0xD0;
        int r2 = 0x90;

        int c = (r << 0) | r2;
        System.out.print(c);

       /* try{
            InputStream is = new FileInputStream("bookings.json");

            byte[] buffer = new byte[1024];

            int r;
            while((r = is.read(buffer)) != -1) {
                // строим стороку из массива, указываем какую его часть надо взять
                if((r & 128) == 0) {
                    // символ состоит из одного байта
                    System.out.print((char) r);
                } else if ((r & 192) == 192) { // проверили 11000000
                    // символ состоит из двух байт
                    int r2 = is.read();
                    int c = (r << 8) + r2;
                    System.out.println((char) c);
                }
                System.out.print((char) r);
            }

            is.close();
        } catch (FileNotFoundException err) {
            System.out.println("Файл не найден");
        } catch (IOException e){
            System.out.println("Ошибка ввода/вывода");
        }
     */
    }
}
