import java.util.Optional;

public class ChainingOptionals {
    public static void main(String[] args) {
        threeDigit_Java7(Optional.empty());
        threeDigit_Java7(Optional.of(4));
        threeDigit_Java7(Optional.of(123));

        threeDigit_Java8(Optional.empty());
        threeDigit_Java8(Optional.of(4));
        threeDigit_Java8(Optional.of(123));

        Optional<String> optional = Optional.of("123");
        Optional<Integer> result = optional.map(String::length);
        System.out.println(result.get());

        Optional<Optional<Integer>> result1 = optional.map(ChainingOptionals::calculator);
        System.out.println(result1.get().get());

        Optional<Integer> result2 = optional.flatMap(ChainingOptionals::calculator);
        System.out.println(result2.get());
    }

    private static Optional<Integer> calculator(String s) {
        return Optional.of(s.length());
    }

    private static void threeDigit_Java8(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    private static void threeDigit_Java7(Optional<Integer> optional) {
        if (optional.isPresent()) {
            Integer num = optional.get();
            String string = "" + num;
            if (string.length() == 3) {
                System.out.println(string);
            }
        }
    }
}