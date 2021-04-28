import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingMaps {
    public static void main(String[] args) {
        Map<String, Integer> map = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        //reverse key into values
        Map<Integer, String> map1 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1 + "," + s2));
        System.out.println(map1);
        System.out.println(map1.getClass());

        TreeMap<Integer, String> map2 = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.toMap(String::length,
                        Function.identity(),//s->s
                        (s1, s2) -> s1 + "," + s2,
                        TreeMap::new));
        System.out.println(map2);
        System.out.println(map2.getClass());
    }
}