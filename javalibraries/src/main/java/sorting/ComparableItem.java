package sorting;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

class ComparableItem implements Comparable<ComparableItem> {
    public final String name;
    public final Double price;
    public final Boolean isAlive;

    public ComparableItem(String name, Double price, Boolean isAlive) {
        this.name = name;
        this.price = price;
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

// Only allowed one
    @Override
    public int compareTo(ComparableItem item) {
        // Correct implementation - faster
        return Double.compare(this.price, item.price);
//
//         Doubly Avoid!!! -> integer overflow + to -
//        return (int) (this.price - item.price);

        // Avoid!! verbose and error prone
//        if (this.price > item.price)
//            return 1;
//        else if (this.price.equals(item.price))
//            return 0;
//        else
//            return -1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparableItem that = (ComparableItem) o;

        if (!name.equals(that.name)) return false;
        if (!price.equals(that.price)) return false;
        return isAlive.equals(that.isAlive);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + isAlive.hashCode();
        return result;
    }
}
