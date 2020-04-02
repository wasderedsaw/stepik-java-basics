import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int index = 0;
        while(in.hasNext()) {
            if(index % 2 != 0) {
                list.add(in.nextInt());
            } else {
                in.nextInt();
            }
            index++;
        }
        Collections.reverse(list);
        for (Integer element:
             list) {
            System.out.println(element);
        }
    }
}
