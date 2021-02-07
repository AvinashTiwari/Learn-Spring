package bizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzzSolOne {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    private static void fizzBuzz(int num) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(System.out::println);
    }
}
