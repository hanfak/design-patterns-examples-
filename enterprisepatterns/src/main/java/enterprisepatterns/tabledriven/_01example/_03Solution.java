package enterprisepatterns.tabledriven._01example;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static java.math.BigInteger.valueOf;

/*
 * A simple solution, would be to return a simple function with logical checks resulting correct output
 *
 * Examples here to remove if statements,
 * as these can grow unwieldly if predicate logic increases in complexity or return value requires complex calculations
 *
 * */
public class _03Solution {

    // Base case
    static Optional<BigDecimal> price(BigInteger amount) {
        if (greaterThan(amount, 0L) && lessThan(amount, 5L)) {
            return Optional.of(BigDecimal.valueOf(5L));
        }
        if (greaterThan(amount, 6L) && lessThan(amount, 10L)) {
            return Optional.of(BigDecimal.valueOf(4L));
        }
        if (greaterThan(amount, 11L) && lessThan(amount, 20L)) {
            return Optional.of(BigDecimal.valueOf(3L));
        }
        if (greaterThan(amount, 21L)) {
            return Optional.of(BigDecimal.valueOf(2.5));
        }

        return Optional.empty();
    }

    // We see a pattern here: the predicate and return value can be extracted and the if statements dont need to be run in order ( but this might be necessary for performance)
    // so can extract out into a map, abstract the all the if statements to one
    // The map can be passed in as a constructor arg or arg of function or have a setter that overrides the default rules
    static Map<AmountRule, BigDecimal> ruleDataSet = new LinkedHashMap<>(); // Done statically to init once
    // Use of linkedhashmap, is to preserve order of iteration

    static {
        // Values can be populated by a dev easily here or it can be done using a config file
        // Having data here does make it hard to understand what is going with it
        // Also leads to being stuck in this form, lets there is different data (would use string to allow any number to be passed in to big int)
        //      such as checks on product types
        ruleDataSet.put(new AmountRule(0L, 5L), BigDecimal.valueOf(5L));
        ruleDataSet.put(new AmountRule(6L, 10L), BigDecimal.valueOf(4L));
        ruleDataSet.put(new AmountRule(11L, 20L), BigDecimal.valueOf(3L));
        ruleDataSet.put(new AmountRule(21L, Long.MAX_VALUE), BigDecimal.valueOf(2.5));
        // Not the best, as BigInt can String values which parse to larger then MAX VALUE, or it can be determined by the stakeholders
        // If it is really a large number (bigger than long), than we can use Strings instead or big objects
    }

    static Optional<BigDecimal> price2(BigInteger amount) {
        for (var ruleData : ruleDataSet.entrySet()) {
            if (greaterThan(amount, ruleData.getKey().lowerBoundAmount) && lessThan(amount, ruleData.getKey().upperBoundAmount)) {
                return Optional.of(ruleData.getValue());
            }
        }
        return Optional.empty();
    }

    // Instead of using longs in our map, we can use big int, big decimal
    static Map<AmountRule3, BigDecimal> ruleDataSet3 = new LinkedHashMap<>(); // Done statically to init once

    static {
        ruleDataSet3.put(new AmountRule3(valueOf(0L), valueOf(5L)), BigDecimal.valueOf(5L));
        ruleDataSet3.put(new AmountRule3(valueOf(6L), valueOf(10L)), BigDecimal.valueOf(4L));
        ruleDataSet3.put(new AmountRule3(valueOf(11L),valueOf(20L)), BigDecimal.valueOf(3L));
        ruleDataSet3.put(new AmountRule3(valueOf(21L),valueOf(Long.MAX_VALUE)), BigDecimal.valueOf(2.5));
    }

    static Optional<BigDecimal> price3(BigInteger amount) {
        for (var ruleData : ruleDataSet3.entrySet()) {
            if (greaterThan(amount, ruleData.getKey().lowerBoundAmount) && lessThan(amount, ruleData.getKey().upperBoundAmount)) {
                return Optional.of(ruleData.getValue());
            }
        }
        return Optional.empty();
    }

    private static boolean lessThan(BigInteger amount, BigInteger val) {
        return amount.compareTo(val) < 0;
    }

    private static boolean greaterThan(BigInteger amount, BigInteger val) {
        return amount.compareTo(val) > 0;
    }

    private static boolean lessThan(BigInteger amount, long val) {
        return amount.compareTo(valueOf(val)) < 0;
    }

    private static boolean greaterThan(BigInteger amount, long val) {
        return amount.compareTo(valueOf(val)) > 0;
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
    }

    private static record AmountRule(long lowerBoundAmount, long upperBoundAmount) { }
    private static record AmountRule3(BigInteger lowerBoundAmount, BigInteger upperBoundAmount) { }
}
