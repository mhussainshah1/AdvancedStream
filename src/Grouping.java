import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grouping {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);

        Map<Integer, Set<String>> map1 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map1);

        TreeMap<Integer, Set<String>> map2 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map2);

        TreeMap<Integer, List<String>> map3 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map3);
    }
}