package refactoring.dry.example1._03_2allshareissues_fix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// This can be used by either ABCD
public class SharedWorkerImpl implements SharedWorker {

    public static void main(String... args) {

    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet()).size();
        nums.length
        List<Integer> ts = Arrays.asList(nums);
        Set<Integer> set = new HashSet<Integer>(ts);
        return set.size() != nums.length;
    }
}
    @Override
    public String execute(String input) {
        return input.toLowerCase();
    }
}