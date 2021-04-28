import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingCollectors {
    public static void main(String[] args) {
        String result = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.joining(","));
        System.out.println(result);

        Double results = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.averagingInt(String::length));
        System.out.println(results);

        Set<String> result1 = Stream.of("lions","toads", "tigers", "bears")
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toSet());
        System.out.println(result1);

        TreeSet<String> result2 = Stream.of("lions", "toads", "tigers", "bears")
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result2);
    }
}