package functional.com.chapter1.functionalinterfaces.runnable;

import java.util.Arrays;

public class TimingTests {

    /**
     * Use functional interface runnable
     *
     * This just calls the lambda and returns void
    **/

    public static void main(String[] args) {
        for (int i = 3; i < 8; i++) {
            int size = (int) Math.pow(10, i);
            System.out.printf("Sorting array of length %,d.\n", size);
            Runnable runnable = () -> sortArray(size);
            TimingUtils.timeOp(runnable);
        }
    }

    private static double[] randomNums(int length) {
        double[] nums = new double[length];
        for(int i=0; i<length; i++) {
            nums[i] = Math.random();
        }
        return(nums);
    }

    private static void sortArray(int length) {
        double[] nums = randomNums(length);
        Arrays.sort(nums);
    }
}
