package enterprisepatterns.tabledriven._01example;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

/*
 * A simple solution, would be to return a simple function with logical checks resulting correct output
 *
 * Allows non dev to set the data to be used for the rules
 *
 * */
public class _06Solution {
    // Base
    static Map<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules = new LinkedHashMap<>();

    static {
        rules.put(matchingTwo(0L, 5L), calculateOne("5"));
        rules.put(matchingTwo(6L, 10L), calculateOne("4"));
        rules.put(matchingTwo(11L, 20L), calculateOne("3"));
        rules.put(matchingOne(21L) ,calculateOne("2.5"));
    }

    // Requires standard ie csv style, a parser
    // TODO: 20/05/2023 parse config file at construction of object (start up, requires a start ie new deployment)
    // TODO: 20/05/2023 when changes in config file, in function check file has changed and update the map (first call is slow, but faster after)
    // TODO: 20/05/2023 when changes in config file, use observer to reload map (Check not done in function, but needs to block function from running and let function finish before updating to prevent issues

    private static Function<BigInteger, BigDecimal> calculateOne(String l) {
        return amount -> new BigDecimal(l);
    }

    private static Predicate<BigInteger> matchingOne(long l) {
        return amount -> greaterThan(amount, valueOf(l));
    }

    private static Predicate<BigInteger> matchingTwo(long l, long l2) {
        return amount -> greaterThan(amount, valueOf(l)) && lessThan(amount, valueOf(l2));
    }

    private static boolean lessThan(BigInteger amount, BigInteger val) {
        return amount.compareTo(val) < 0;
    }

    private static boolean greaterThan(BigInteger amount, BigInteger val) {
        return amount.compareTo(val) > 0;
    }

    public static void main(String... args) {

        System.out.println();
        System.out.println();

        Calculator calculator = new Calculator(rules);
        System.out.println(calculator.price(BigInteger.valueOf(0)));
        System.out.println(calculator.price(BigInteger.valueOf(3L)));
        System.out.println(calculator.price(BigInteger.valueOf(8L)));
        System.out.println(calculator.price(BigInteger.valueOf(15L)));
        System.out.println(calculator.price(BigInteger.valueOf(30L)));
        System.out.println(calculator.price(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

    }

    static class Calculator {

        private final Map<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules;

        Calculator(Map<Predicate<BigInteger>, Function<BigInteger, BigDecimal>> rules) {
            this.rules = rules;
        }

        Optional<BigDecimal> price(BigInteger amount) {
            if (lessThan(amount, ONE)) return Optional.empty();

            return rules.entrySet().stream()
                    .filter(rule -> rule.getKey().test(amount))
                    .map(rule -> rule.getValue().apply(amount))
                    .findFirst();
        }
    }

}
