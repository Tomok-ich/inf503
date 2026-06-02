import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonBracketCheckerTest {

    @TempDir
    Path tempDir;

    private Path createFile(String name, String content) throws IOException {
        Path p = tempDir.resolve(name);
        Files.writeString(p, content);
        return p;
    }

    @Test
    void testNullFileName() {
        assertThrows(NullPointerException.class,
                () -> JsonBracketChecker.check(null));
    }

    @Test
    void testEmptyFileName() {
        assertThrows(NullPointerException.class,
                () -> JsonBracketChecker.check(""));
    }

    @Test
    void testFileNotFound() {
        assertThrows(FileNotFoundException.class,
                () -> JsonBracketChecker.check("nonexistent_xyz_123.json"));
    }

    @Test
    void testBinaryFile() throws IOException {
        Path bin = tempDir.resolve("bin.dat");
        Files.write(bin, new byte[]{0, 1, 2, 3});

        assertThrows(JsonBracketChecker.NotTextFileException.class,
                () -> JsonBracketChecker.check(bin.toString()));
    }

    // Тесты корректности

    @Test
    void testValidJson() throws Exception {
        Path f = createFile("ok.json", "{\"name\": \"John\", \"items\": [1, 2, 3]}");
        assertEquals(0, JsonBracketChecker.check(f.toString()));
    }

    @Test
    void testNestedValid() throws Exception {
        Path f = createFile("nested.json", "{\"a\": {\"b\": [{\"c\": 1}]}}");
        assertEquals(0, JsonBracketChecker.check(f.toString()));
    }

    @Test
    void testUnmatchedClosing() throws Exception {
        Path f = createFile("bad1.json", "{}}");
        assertEquals(3, JsonBracketChecker.check(f.toString()));
    }

    @Test
    void testWrongPair() throws Exception {
        Path f = createFile("bad2.json", "{]");
        assertEquals(2, JsonBracketChecker.check(f.toString()));
    }

    @Test
    void testUnclosed() throws Exception {
        Path f = createFile("bad3.json", "{\"a\": 1");
        assertEquals(1, JsonBracketChecker.check(f.toString()));
    }

    @Test
    void testBracketsInsideString() throws Exception {
        Path f = createFile("str.json", "{\"text\": \"}{][\"}");
        assertEquals(0, JsonBracketChecker.check(f.toString()));
    }
}
