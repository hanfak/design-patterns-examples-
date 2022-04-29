package functional.com.chapter1.functionalinterfaces.betterstring;

@FunctionalInterface
public interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}
