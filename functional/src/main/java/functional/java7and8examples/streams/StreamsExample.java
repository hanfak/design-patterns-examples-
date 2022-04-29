package functional.java7and8examples.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamsExample {
    public static void main(String[] args) {
        new Random()
                .ints(0, 11)
                .limit(10)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        System.out.println();

        String[] cities = {
                "New York",
                "London",
                "Paris",
                "Berlin",
                "BrasÌlia",
                "Tokyo",
                "Beijing",
                "Jerusalem",
                "Cairo",
                "Riyadh",
                "Moscow"
        };

        IntStream.range(0, 11)
                .mapToObj(i -> cities[i])
                .forEach(System.out::println);
        System.out.println();


        Arrays.stream(cities, 0, 11)
                .forEach(System.out::println);
        System.out.println();


        System.out.println();

        System.out.println(IntStream
                .range(0, 10)
                .reduce(0, (x, y) -> x + y));
        System.out.println();

        System.out.println(IntStream
                .range(0, 10)
                .reduce(0, Integer::sum));
    }

}
