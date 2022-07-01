package algorithms.arrays.twosum;

import java.util.HashMap;
import java.util.Map;

public class _02Example {
    // Uses property of map - O(1) lookup
    // Looks for first match then exits
    // O(n-1) space, if last two numbers match it will need to go through whole array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndexMapper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valueToIndexMapper.containsKey(complement)) {
                return new int[]{i, valueToIndexMapper.get(complement)};
            }
            valueToIndexMapper.put(nums[i], i);
        }

        return new int[]{};
    }
}
