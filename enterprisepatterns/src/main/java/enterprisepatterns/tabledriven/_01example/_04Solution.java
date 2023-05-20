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
 * Examples here to remove if statements,
 * as these can grow unwieldly if predicate logic increases in complexity or return value requires complex calculations
 *
 * extracting out rules and output, so they dont have to confirm to standard (predicates and functions)
 *
 * Issues occur when a new type passed into function to use in matching(predicate) or calculation (function) part
 *
 * */
public class _04Solution {

    // The map can be passed in as a constructor arg or arg of function or have a setter that overrides the default rules
    // Using predicates allows the devs to allow any type of matching rule to be used so is very extendable
    static Map<Predicate<BigInteger>, BigDecimal> rules = new LinkedHashMap<>();

    static {
        // The predicate can be extracted to methods if too complex
        // The values can be populated later
        rules.put(amount -> greaterThan(amount, valueOf(0L)) && lessThan(amount, valueOf(5L)), BigDecimal.valueOf(5L));
        rules.put(amount -> greaterThan(amount, valueOf(6L)) && lessThan(amount, valueOf(10L)), BigDecimal.valueOf(4L));
        rules.put(amount -> greaterThan(amount, valueOf(11L)) && lessThan(amount, valueOf(20L)), BigDecimal.valueOf(3L));
        rules.put(amount -> greaterThan(amount, valueOf(21L)), BigDecimal.valueOf(2.5));
    }

    static Optional<BigDecimal> price(BigInteger amount) {
        for (var ruleData : rules.entrySet()) {
            if (ruleData.getKey()
                    .test(amount)) {
                return Optional.of(ruleData.getValue());
            }
        }
        return Optional.empty();
    }

    // Can use a guard clause here, which will prevent going through rules (esp if there are lots of them or very complex to check)
    static Optional<BigDecimal> price3(BigInteger amount) {
        if (!lessThan(amount, ONE)) {
            for (var ruleData : rules.entrySet()) {
                if (ruleData.getKey()
                        .test(amount)) {
                    return Optional.of(ruleData.getValue());
                }
            }
        }
        return Optional.empty();
    }

    // Can use stream api to make it easier to follow
    static Optional<BigDecimal> price2(BigInteger amount) {
        return rules.entrySet().stream()
                .filter(rule -> rule.getKey().test(amount))
                .map(Map.Entry::getValue)
                .findFirst(); // Can use this only if rules are independent, so filter will only result in one rule back
    }

    // Make the output more extendable, by making the map take a function, and the input can be used however
    static Map<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules4 = new LinkedHashMap<>();

    static {
        // The predicate can be extracted to methods if too complex
        // The values can be populated later
        rules4.put(amount -> greaterThan(amount, valueOf(0L)) && lessThan(amount, valueOf(5L)), amount -> BigDecimal.valueOf(5L));
        rules4.put(amount -> greaterThan(amount, valueOf(6L)) && lessThan(amount, valueOf(10L)), amount -> BigDecimal.valueOf(4L));
        rules4.put(amount -> greaterThan(amount, valueOf(11L)) && lessThan(amount, valueOf(20L)), amount -> BigDecimal.valueOf(3L));
        rules4.put(amount -> greaterThan(amount, valueOf(21L)), amount -> BigDecimal.valueOf(2.5));
    }
    static Optional<BigDecimal> price4(BigInteger amount) {
        if (lessThan(amount, ONE)) return Optional.empty();

        return rules4.entrySet().stream()
                .filter(rule -> rule.getKey().test(amount))
                .map(rule -> rule.getValue().apply(amount))
                .findFirst();
    }

    // To reduce lots of changes can extract methods out
    static Map<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules5 = new LinkedHashMap<>();

    // Extracted the predicates to methods, so less code to change
    static {
        rules5.put(matchingTwo(0L, 5L), calculateOne("5"));
        rules5.put(matchingTwo(6L, 10L), calculateOne("4"));
        rules5.put(matchingTwo(11L, 20L), calculateOne("3"));
        rules5.put(matchingOne(21L) ,calculateOne("2.5"));
    }

    static Optional<BigDecimal> price5(BigInteger amount) {
        if (lessThan(amount, ONE)) return Optional.empty();

        return rules5.entrySet().stream()
                .filter(rule -> rule.getKey().test(amount))
                .map(rule -> rule.getValue().apply(amount))
                .findFirst();
    }

    private static Function<BigInteger, BigDecimal> calculateOne(String l) {
        return amount -> new BigDecimal(l);
    }

    // If these changes to include another variable than will need to change to use a BiPrdeicate in the signature here and the map defintion
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

        System.out.println(price(BigInteger.valueOf(0)));
        System.out.println(price(BigInteger.valueOf(3L)));
        System.out.println(price(BigInteger.valueOf(8L)));
        System.out.println(price(BigInteger.valueOf(15L)));
        System.out.println(price(BigInteger.valueOf(30L)));
        System.out.println(price(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

        System.out.println();
        System.out.println();

        System.out.println(price2(BigInteger.valueOf(0)));
        System.out.println(price2(BigInteger.valueOf(3L)));
        System.out.println(price2(BigInteger.valueOf(8L)));
        System.out.println(price2(BigInteger.valueOf(15L)));
        System.out.println(price2(BigInteger.valueOf(30L)));
        System.out.println(price2(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

        System.out.println();
        System.out.println();

        System.out.println(price5(BigInteger.valueOf(0)));
        System.out.println(price5(BigInteger.valueOf(3L)));
        System.out.println(price5(BigInteger.valueOf(8L)));
        System.out.println(price5(BigInteger.valueOf(15L)));
        System.out.println(price5(BigInteger.valueOf(30L)));
        System.out.println(price5(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

    }

}
