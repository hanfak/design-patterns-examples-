package javalibraries.sorting;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Comparator;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

class ComparableItem3 implements Comparable<ComparableItem3> {
    public final String name;
    public final Double price;
    public final Boolean isAlive;

    public ComparableItem3(String name, Double price, Boolean isAlive) {
        this.name = name;
        this.price = price;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

// Opposite order
//    private static final Comparator<ComparableItem3> COMPARATOR =
//            Comparator.comparing((ComparableItem3 comparableItem3) -> comparableItem3.getName())
//                .thenComparing((ComparableItem3 item) -> item.price); // or thenComparingDouble

    private static final Comparator<ComparableItem3> COMPARATOR =
            Comparator.comparingDouble((ComparableItem3 item) -> item.price)
                    .thenComparing(ComparableItem3::getName)
            ;

    // Using comparator to compare
    @Override
    public int compareTo(ComparableItem3 item) {
        return COMPARATOR.compare(this, item);
    }
}
