package functional.com.chapter1.functionalinterfaces.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class TimingTests {

    /**
     * Use functional interface runnable
     *
     * This just calls the lambda and returns a type
    **/

    public static void main(String[] args) throws Exception {
        final List<Integer> integers =  Arrays.asList(1,2,3,4,5);

        Callable callable = () -> sumList(integers);

        TimingUtils.timeOp(callable);

        Callable callable1 = Utils.getCallable(integers);
        TimingUtils.timeOp(callable1);

    }

    private static int sumList(List<Integer> integers) {
        return integers.stream()
                .mapToInt(i -> i + 1)
                .peek(System.out::println)
                .sum();
    }

}

class Utils {
    private static int sumList(List<Integer> integers) {
        return integers.stream()
                .mapToInt(i -> i + 1)
                .peek(System.out::println)
                .sum();
    }

    public static Callable getCallable(List<Integer> integers) {
        return () -> sumList(integers);
    }


}
