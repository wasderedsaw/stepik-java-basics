import java.util.HashSet;
import java.util.Set;

public class Main {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> answer = new HashSet<>();
        for (T element:
             set1) {
            if(!set2.contains(element)) {
                answer.add(element);
            }
        }
        for (T element:
                set2) {
            if(!set1.contains(element)) {
                answer.add(element);
            }
        }
        return answer;
    }
}
