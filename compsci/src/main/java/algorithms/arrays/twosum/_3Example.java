package algorithms.arrays.twosum;

public class _3Example {

    // Finds all possible pairs
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = nums[j] + nums[j - i];
                if (sum == target) {
                    return new int[]{j - i, j};
                }

            }
        }

        return new int[]{};
    }

    public static void main(String... args) {
       twoSum(new int[]{3,2,4,5}, 8);
    }
}

    /*
    sliding window
    [3,2,4,5]
     - x - -
     y - - -
     ------
     - - x -
     - y - -
     ------
      - - - c
      - - y -
      =========
      - - x -
      y - - -
      ---------
      - - - x
      - y - -
      ---------

    * */