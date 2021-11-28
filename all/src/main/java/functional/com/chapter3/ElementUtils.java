package functional.com.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hanfak on 02/07/2017.
 */
public class ElementUtils {
    public static <T> List<T> allMatches(List<T> candidates,
                                         Predicate<T> matchFunction) {
        List<T> results = new ArrayList<>();
        for(T possibleMatch: candidates) {
            if(matchFunction.test(possibleMatch)) {
                results.add(possibleMatch);
            }
        }
        return(results);
    }
}
