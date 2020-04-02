import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class Main {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int temp = reader.read();
        if (temp == -1) {
            return "";
        }
        StringBuilder temporary = new StringBuilder("");
        while (temp > 0) {
            temporary.append((char) temp);
            temp = reader.read();
        }
        String answer = temporary.toString();
        return answer;
    }
}
