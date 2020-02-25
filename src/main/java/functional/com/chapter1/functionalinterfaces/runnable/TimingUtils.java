package functional.com.chapter1.functionalinterfaces.runnable;

public class TimingUtils {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void timeOp(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        long endTime = System.nanoTime();
        double elapsedSeconds = (endTime - startTime)/ONE_BILLION;
        System.out.printf("\tElapsed time: %.3f seconds.\n\n", elapsedSeconds);
    }
}
