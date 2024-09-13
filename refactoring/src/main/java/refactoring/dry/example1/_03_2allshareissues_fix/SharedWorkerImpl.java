package refactoring.dry.example1._03_2allshareissues_fix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// This can be used by either ABCD
public class SharedWorkerImpl implements SharedWorker {

    @Override
    public String execute(String input) {
        return input.toLowerCase();
    }
}