import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Partitioning {
    public static void main(String[] args) {
        Map<Boolean, List<String>> map = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map);

        map = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map);

        Map<Boolean, Set<String>> map1 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map1);

        Map<Integer, Long> map3 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map3);

    }
}