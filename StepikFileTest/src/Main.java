import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException{
//        InputStream in = System.in;
        byte[] arr = new byte[]{65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        InputStream in = new ByteArrayInputStream(arr);
        int a = in.read();
        int b = in.read();
        if (a == -1) {
            System.out.flush();
        } else {
            if (b == -1) {
                System.out.println(a);
                System.out.flush();
            } else {
                while (b > 0) {
                    if (a == 13 && b == 10) {
                        System.out.println(b);
                        a = b;
                        b = in.read();
                    } else {
                        System.out.println(a);
                    }
                    a = b;
                    b = in.read();
                }
                System.out.println(a);
                System.out.flush();
            }
        }
    }
}
