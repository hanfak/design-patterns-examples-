package enterprisepatterns.tabledriven._01example;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import static java.math.BigInteger.*;

/*
 * A simple solution, would be to return a simple function with logical checks resulting correct output
 *
 * Examples here to handle different signatures
 *
 * */
public class _02Solution {

    // Instead returning String, return optional to make clear what could be returned, let consumer deal with output
    static Optional<String> price(int amount) {
        // Can use curly braces
        if (amount >= 1 && amount <= 5) return Optional.of("5");
        if (amount >= 6 && amount <= 10) return Optional.of("4");
        if (amount >= 11 && amount <= 20) return Optional.of("3");
        if (amount > 21) return Optional.of("2.5");

        return Optional.empty();
    }

    // Use of exception, as it is runtime, consumers (or transitive consumers) may not know about it and could blow up unexpectedly
    // The api hides the fact that it can blow up, but consumer should test the api instead of mocking
    static String price2(int amount) {
        // Can use curly braces
        if (amount >= 1 && amount <= 5) return "5";
        if (amount >= 6 && amount <= 10) return "4";
        if (amount >= 11 && amount <= 20) return "3";
        if (amount > 21) return "2.5";

        throw new IllegalArgumentException("Amount provided %s has unknown price".formatted(amount));
    }

    // This overcomes the problem in price2, the exception is part of signature and now the compiler will complain if not handled by consumer
    // This is not great if there are multiple checked exceptions thrown but ok for a few
    static String price3(int amount) throws IllegalArgumentException {
        // Can use curly braces
        if (amount >= 1 && amount <= 5) return "5";
        if (amount >= 6 && amount <= 10) return "4";
        if (amount >= 11 && amount <= 20) return "3";
        if (amount > 21) return "2.5";

        throw new IllegalArgumentException("Amount provided %s has unknown price".formatted(amount));
    }

    // If internal, can create your own custom exception this can be used internally and handled by an exception handler (with loggign) later in the flow
    // This signature can also have the throw ..
    // the consumer can wrap it in an adapter and convert the exception to a standard or internal custome exception (try/catch)
    // Having a custom exception can lead to consumers leaking library details within there code, leading to changes in library to cause rework (better to use adapted
    static String price4(int amount) {
        // Can use curly braces
        if (amount >= 1 && amount <= 5) return "5";
        if (amount >= 6 && amount <= 10) return "4";
        if (amount >= 11 && amount <= 20) return "3";
        if (amount > 21) return "2.5";

        throw new UnknownAmountException("Amount provided %s has unknown price".formatted(amount));
    }

    // Issues with others is the amount is an int, which will have a value of 2.14billion, thus bigger numbers will lead to numeric overflow
    // Can have defensive programming (Gaurd clause) to throw exception, but this may not be in the interest of the stakeholders
    // Can ignore if stakeholders believer this will never be a problem or let consumer handle the size check (As other rules might be in place ie stock check)
    // Here we used java library BigInteger which can handle large numbers, the consumer must pass a bigint but this is a java lib so no issues of pollutions (unless using java 9 modules)
    //       yes can be less performant than using an int, but we should measure before changing it
    // Thw predicates now look less readable (but can extract to methods to hide this)
    static String price5(BigInteger amount) {
        // Can use curly braces
        if (amount.compareTo(ZERO) > 0 && amount.compareTo(valueOf(5L)) < 0) return "5";
        if (amount.compareTo(valueOf(6L)) > 0  && amount.compareTo(valueOf(10L)) < 0) return "4";
        if (amount.compareTo(valueOf(11L)) > 0  && amount.compareTo(valueOf(20L)) < 0) return "3";
        if (amount.compareTo(valueOf(21L)) > 0) return "2.5";

        throw new IllegalArgumentException("Amount provided %s has unknown price".formatted(amount));
    }

    static String price6(BigInteger amount) throws IllegalArgumentException {
        // Can use curly braces
        if (greaterThan(amount, 0L) && lessThan(amount, 5L)) return "5";
        if (greaterThan(amount, 6L) &&  lessThan(amount, 10L)) return "4";
        if (greaterThan(amount, 11L)&&  lessThan(amount, 20L)) return "3";
        if (greaterThan(amount, 21L)) return "2.5";

        throw new IllegalArgumentException("Amount provided %s has unknown price".formatted(amount));
    }

    // Amoint is an string and this can be any value int or decimal, the consumer will have to handle this
    // Issues will arise if the consumer has to convert a string value that might be a non parsable value
    // Now can return your own type (ie Money object) but then this will leak into consumer code, could conflict, but can be dealt wiht using adpater
    // alternative is to use java lib like float, and consumers will need to handle floating point arithematic or possibly wrap it in their own adapter
    //      But this can lead to function to have to deal with FPA if the calculation becomes complex later on
    // Can use BigDecimal, which is java lib and suitable for use as a money type and easy to handle arithmatic with,
    //      yes can be less performant, but we should measure before changing it
    static BigDecimal price7(BigInteger amount) throws IllegalArgumentException {
        // Can use curly braces
        if (greaterThan(amount, 0L) && lessThan(amount, 5L)) return BigDecimal.valueOf(5L);
        if (greaterThan(amount, 6L) &&  lessThan(amount, 10L)) return BigDecimal.valueOf(4L);
        if (greaterThan(amount, 11L)&&  lessThan(amount, 20L)) return BigDecimal.valueOf(3L);
        if (greaterThan(amount, 21L)) return BigDecimal.valueOf(2.5);

        throw new IllegalArgumentException("Amount provided %s has unknown price".formatted(amount));
    }

    private static boolean lessThan(BigInteger amount, long val) {
        return amount.compareTo(valueOf(val)) < 0;
    }

    private static boolean greaterThan(BigInteger amount, long val) {
        return amount.compareTo(valueOf(val)) > 0;
    }

    public static void main(String... args) {
        System.out.println(price(0));
        System.out.println(price(3));
        System.out.println(price(8));
        System.out.println(price(15));
        System.out.println(price(30));
        int amount = Integer.MAX_VALUE + 1;
        System.out.println("amount = " + amount);
//        System.out.println(price(amount));

        System.out.println();
        System.out.println();

//        System.out.println(price5(BigInteger.valueOf(0)));
        System.out.println(price5(BigInteger.valueOf(3L)));
        System.out.println(price5(BigInteger.valueOf(8L)));
        System.out.println(price5(BigInteger.valueOf(15L)));
        System.out.println(price5(BigInteger.valueOf(30L)));
        System.out.println(price5(BigInteger.valueOf(Integer.MAX_VALUE + 1L)));
    }

    private static class UnknownAmountException extends RuntimeException {

        public UnknownAmountException(String message) {
            super(message);
        }
    }
}
