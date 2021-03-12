package javalibraries.sorting;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Comparator;
import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

class Item {
    public final String name;
    public final Double price;
    public final Boolean isAlive;

    public Item(String name, Double price, Boolean isAlive) {
        this.name = name;
        this.price = price;
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        return isAlive != null ? isAlive.equals(item.isAlive) : item.isAlive == null;
    }

    @Override
    public int hashCode() {
        // Slower but more concise
        int hash = Objects.hash(name, price, isAlive);

        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }


    public static Comparator<Item> compartorNameAscending
            = (item1, item2) -> {

        String ItemName1 = item1.name.toUpperCase();
        String ItemName2 = item2.name.toUpperCase();

        //ascending order
        return ItemName1.compareTo(ItemName2);

    };

    public static Comparator<Item> compartorNameDescending
            = (item1, item2) -> {

        String ItemName1 = item1.name.toUpperCase();
        String ItemName2 = item2.name.toUpperCase();

        //descending order
        return ItemName2.compareTo(ItemName1);
    };

    public static Comparator<Item> compartorPriceDescending
            = (item1, item2) -> {
        if (item1.price > item2.price)
            return -1;
        else
            return 1;
    };

    public static Comparator<Item> compartorPriceAscending
            = (item1, item2) -> {
        if (item1.price > item2.price)
            return 1;
        else
            return -1;
    };
}
