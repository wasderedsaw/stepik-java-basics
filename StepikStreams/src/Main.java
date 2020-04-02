import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static IntStream pseudoRandomStream(int seed) {
        IntStream resultingStream = IntStream.iterate(seed, n -> (n * n / 10 % 10) + 10 * (n * n / 100 % 10) + 100 * (n * n / 1000 % 10));
        return resultingStream;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> sorted = stream.sorted(order).collect(Collectors.toList());
        if (sorted.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = sorted.get(0);
            T max = sorted.get(sorted.size() - 1);
            minMaxConsumer.accept(min, max);
        }
    }

    public static void main(String[] args) {
        IntStream test = pseudoRandomStream(13).limit(20);
        test.forEach(System.out::println);
    }
}
