package functional.otherexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceExamples {
    // https://www.logicbig.com/tutorials/core-java-tutorial/java-util-stream/reduction.html
    public static final List<Integer> numberList = Arrays.asList(1, 2, 3, 5, 6, 7);
    public static final List<Integer> numberList1 = Arrays.asList(0, 1, 2, 3, 5, 6, 7);

    public static void main(String[] args) {
        Integer sum = ReduceExamples.numberList.stream().reduce(0, (accumulator, element) -> accumulator + element);
        System.out.println("sum = " + sum);

        // if identity is not set, it will take the first element of the list
        Optional<Integer> sumNoAccumulator = ReduceExamples.numberList.stream().reduce((accumulator, element) -> accumulator + element);
        System.out.println("sumNoAccumulator = " + sumNoAccumulator.get());

        Optional<Integer> productNoAccumulator = ReduceExamples.numberList1.stream().reduce((accumulator, element) -> accumulator * element);
        System.out.println("productNoAccumulator = " + productNoAccumulator.get());

        int i = Stream.of("2", "3", "4", "5")
                .parallel()
                .reduce(0, (integer, s) -> Integer.sum(integer, Integer.parseInt(s)),
                        Integer::sum);

        System.out.println(i);
    }
}
