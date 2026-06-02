import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InfiniteMessageReader extends Reader {

    private final List<String> messages = new ArrayList<>();
    private int messageIndex = 0;
    private int charIndex = 0;
    private boolean closed = false;

    public InfiniteMessageReader(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        );

        String line;
        while ((line = br.readLine()) != null) {
            messages.add(line + "\n");
        }

        if (messages.isEmpty()) {
            messages.add("\n");
        }
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (closed) return -1;

        int count = 0;

        while (count < len) {
            String current = messages.get(messageIndex);

            cbuf[off + count] = current.charAt(charIndex);
            count++;
            charIndex++;

            if (charIndex >= current.length()) {
                charIndex = 0;
                messageIndex++;

                if (messageIndex >= messages.size()) {
                    messageIndex = 0;
                }
            }
        }

        return count;
    }

    @Override
    public void close() {
        closed = true;
    }
}