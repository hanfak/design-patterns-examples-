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
 * Allow consumer to pass in rules
 *
 * */
public class _05Solution {
    // Base
    static LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules = new LinkedHashMap<>();

    static {
        rules.put(matchingTwo(0L, 5L), calculateOne("5"));
        rules.put(matchingTwo(6L, 10L), calculateOne("4"));
        rules.put(matchingTwo(11L, 20L), calculateOne("3"));
        rules.put(matchingOne(21L) ,calculateOne("2.5"));
    }

    static Optional<BigDecimal> price(BigInteger amount) {
        if (lessThan(amount, ONE)) return Optional.empty();

        return rules.entrySet().stream()
                .filter(rule -> rule.getKey().test(amount))
                .map(rule -> rule.getValue().apply(amount))
                .findFirst();
    }

    // create rules and add to constructor
    static LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules2 = new LinkedHashMap<>();

    static {
        rules2.put(matchingTwo(0L, 5L), calculateOne("5"));
        rules2.put(matchingTwo(6L, 10L), calculateOne("4"));
        rules2.put(matchingTwo(11L, 20L), calculateOne("3"));
        rules2.put(matchingOne(21L) ,calculateOne("2.5"));
    }

    // To avoid having guard clause, but not as nice, as using exception
    static LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules3 = new LinkedHashMap<>();

    static {
        rules3.put(baseCaseCheck(1L), handleBaseCase());
        rules3.put(matchingTwo(0L, 5L), calculateOne("5"));
        rules3.put(matchingTwo(6L, 10L), calculateOne("4"));
        rules3.put(matchingTwo(11L, 20L), calculateOne("3"));
        rules3.put(matchingOne(21L) ,calculateOne("2.5"));
    }

    private static Function<BigInteger, BigDecimal> handleBaseCase() {
        throw new IllegalArgumentException();
    }

    private static Predicate<BigInteger> baseCaseCheck(long l) {
        return amount -> lessThan(amount, valueOf(l));
    }

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

        System.out.println(price(BigInteger.valueOf(0)));
        System.out.println(price(BigInteger.valueOf(3L)));
        System.out.println(price(BigInteger.valueOf(8L)));
        System.out.println(price(BigInteger.valueOf(15L)));
        System.out.println(price(BigInteger.valueOf(30L)));
        System.out.println(price(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

        System.out.println();
        System.out.println();

        Calculator calculator = new Calculator(rules2);
        System.out.println(calculator.price(BigInteger.valueOf(0)));
        System.out.println(calculator.price(BigInteger.valueOf(3L)));
        System.out.println(calculator.price(BigInteger.valueOf(8L)));
        System.out.println(calculator.price(BigInteger.valueOf(15L)));
        System.out.println(calculator.price(BigInteger.valueOf(30L)));
        System.out.println(calculator.price(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));

    }

    static class Calculator {

        private final LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules;

        Calculator(LinkedHashMap<Predicate<BigInteger>, Function<BigInteger, BigDecimal>> rules) {
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

    // Instead of gaurd clause, can use the property of the LinkedHashMap to alwasy check the base case first
    static class Calculator2 {

        // Normally use interface, but want to force consumer to use a LinkedHashMap for ordering
        private final LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules;

        Calculator2(LinkedHashMap<Predicate<BigInteger>, Function<BigInteger, BigDecimal>> rules) {
            this.rules = rules;
        }

        Optional<BigDecimal> price(BigInteger amount) {
            try {
                return rules.entrySet().stream()
                        .filter(rule -> rule.getKey().test(amount))
                        .map(rule -> rule.getValue().apply(amount))
                        .findFirst();
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        }
    }

    static class Calculator3 {

        private final LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> rules;

        Calculator3(LinkedHashMap<Predicate<BigInteger>, Function<BigInteger, BigDecimal>> rules) {
            this.rules = rules;
        }

        // consumer can change rules during run time, but will need to handle checks on function if still running and
        // not let run while updating. Also consider if there are multiple replicas, each need to be updated, might need a service to call and observe
        void changeRules(LinkedHashMap<Predicate<BigInteger>, Function<BigInteger,BigDecimal>> newRules) {
            this.rules.clear();
            this.rules.putAll(newRules);
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
