package sorting;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

class ComparableItem2 implements Comparable<ComparableItem2> {
    public final String name;
    public final Double price;
    public final Boolean isAlive;

    public ComparableItem2(String name, Double price, Boolean isAlive) {
        this.name = name;
        this.price = price;
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    // Comparing over mulitple fields
    // unwiedly, as can end up with lots of if statements
    @Override
    public int compareTo(ComparableItem2 item) {
        // Compare in order of most important field
        int result = Double.compare(this.price, item.price);
        if (result == 0) {
            result = String.CASE_INSENSITIVE_ORDER.compare(this.name, item.name);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparableItem2 that = (ComparableItem2) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return isAlive != null ? isAlive.equals(that.isAlive) : that.isAlive == null;
    }
}
