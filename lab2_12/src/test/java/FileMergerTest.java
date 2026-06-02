import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class FileMergerTest {

    @TempDir
    Path tempDir;

    private Path file1, file2, output;

    @BeforeEach
    void setUp() throws IOException {
        file1 = tempDir.resolve("a.txt");
        file2 = tempDir.resolve("b.txt");
        output = tempDir.resolve("out.txt");

        Files.write(file1, "Hello, World!".getBytes());
        Files.write(file2, "Java is cool".getBytes());
    }

    @Test
    void testMergedFileSize() throws IOException {
        FileMerger.merge(file1.toString(), file2.toString(), output.toString());

        long expectedSize = Files.size(file1) + Files.size(file2);
        assertEquals(expectedSize, Files.size(output),
                "Размер итогового файла должен быть суммой размеров исходных");
    }

    @Test
    void testMergedFileContent() throws IOException {
        FileMerger.merge(file1.toString(), file2.toString(), output.toString());

        byte[] content1 = Files.readAllBytes(file1);
        byte[] content2 = Files.readAllBytes(file2);
        byte[] merged = Files.readAllBytes(output);

        // Первая часть итогового файла = file1
        byte[] firstPart = new byte[content1.length];
        System.arraycopy(merged, 0, firstPart, 0, content1.length);
        assertArrayEquals(content1, firstPart, "Первая часть не совпадает с file1");

        // Вторая часть = file2
        byte[] secondPart = new byte[content2.length];
        System.arraycopy(merged, content1.length, secondPart, 0, content2.length);
        assertArrayEquals(content2, secondPart, "Вторая часть не совпадает с file2");
    }

    @Test
    void testBinaryFiles() throws IOException {
        Path bin1 = tempDir.resolve("a.bin");
        Path bin2 = tempDir.resolve("b.bin");
        Path binOut = tempDir.resolve("out.bin");

        Files.write(bin1, new byte[]{1, 2, 3, 4});
        Files.write(bin2, new byte[]{5, 6, 7});

        FileMerger.merge(bin1.toString(), bin2.toString(), binOut.toString());

        assertEquals(7, Files.size(binOut));  // 4 + 3 = 7 байт
    }
}
