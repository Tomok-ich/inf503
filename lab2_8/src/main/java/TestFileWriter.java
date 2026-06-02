import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileWriter {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("text.txt");

            String message = "Hello";
            byte[] data = message.getBytes("UTF-8");

            os.write(data);

            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// java видит String как UTF-16