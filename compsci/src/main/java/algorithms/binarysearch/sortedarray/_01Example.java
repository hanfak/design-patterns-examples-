package algorithms.binarysearch.sortedarray;

public class _01Example {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int midpoint = leftIndex + (rightIndex-leftIndex)/2;
            int valAtMidpoint = nums[midpoint];
            if (valAtMidpoint == target) {
                return midpoint;
            }
            if (valAtMidpoint > target) {
                rightIndex = midpoint - 1;
            } else {
                leftIndex = midpoint + 1;
            }
        }

        return -1;
    }
}
