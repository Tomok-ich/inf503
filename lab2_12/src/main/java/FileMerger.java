import java.io.*;

public class FileMerger {
    public static void merge(String file1, String file2, String output) throws IOException {
        try (InputStream in1 = new BufferedInputStream(new FileInputStream(file1));
             InputStream in2 = new BufferedInputStream(new FileInputStream(file2));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {

            in1.transferTo(out);
            in2.transferTo(out);
        }
    }
}
