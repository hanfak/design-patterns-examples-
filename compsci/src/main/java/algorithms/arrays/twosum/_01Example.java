package algorithms.arrays.twosum;

public class _01Example {
    // Checks up to every pair, excluding repeated pairs
    // O(n^2) time due to double loop
    //O(1) as only one element stored
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[i];
                if (complement == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[] {} ;
    }
}
