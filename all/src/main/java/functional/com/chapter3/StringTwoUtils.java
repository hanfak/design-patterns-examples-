package functional.com.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by hanfak on 02/07/2017.
 */
public class StringTwoUtils {
//    public static List<String> allMatches(List<String> candidates,
//                                          Predicate<String> matchFunction) {
//
//        List<String> results = new ArrayList<>();
//
//        for(String possibleMatch: candidates) {
//            if(matchFunction.test(possibleMatch)) {
//                results.add(possibleMatch);
//            }
//        }
//        return(results);
//    }


    public static List<String> transformedList(List<String> originals,
                                               Function<String, String> transformer) {
        List<String> results = new ArrayList<>();
        for(String original: originals) {
            results.add(transformer.apply(original));
        }
        return(results);
    }
}
