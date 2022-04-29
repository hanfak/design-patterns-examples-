package functional.com.chapter1.functionalinterfaces.callable;

import java.util.concurrent.Callable;

public class TimingUtils {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void timeOp(Callable operation) throws Exception {
        long startTime = System.nanoTime();
        Object callable = operation.call();
        System.out.println(callable);
        long endTime = System.nanoTime();
        double elapsedSeconds = (endTime - startTime)/ONE_BILLION;
        System.out.printf("\tElapsed time: %.3f seconds.\n\n", elapsedSeconds);
    }
}
