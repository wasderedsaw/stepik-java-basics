import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int answer = 0;
        int helper = inputStream.read();
        while(helper > 0) {
            answer = Integer.rotateLeft(answer, 1) ^ helper;
            helper = inputStream.read();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        InputStream stream1 = getStream(new byte[] { 0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream1));
        InputStream stream2 = getStream(new byte[] {});
        System.out.println(checkSumOfStream(stream2));
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }
}
