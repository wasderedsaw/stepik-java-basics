import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { //wtf is that
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);
        double answer = 0.0;
        while(in.hasNext()) {
            if (in.hasNextDouble()) {
                answer += in.nextDouble();
            } else {
                in.next();
            }
        }
        System.out.format(Locale.ENGLISH, "%.6f", answer);
    }
}
