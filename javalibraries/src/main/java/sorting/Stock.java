package sorting;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Stock  implements Comparable<Stock> {
    public final ComparableItem comparableItem;
    public final Integer amountAvailable;


    public Stock(ComparableItem comparableItem, Integer amountAvailable) {
        this.comparableItem = comparableItem;
        this.amountAvailable = amountAvailable;
    }

    @Override
    public int compareTo(Stock stock) {
        int result = Integer.compare(this.amountAvailable, stock.amountAvailable);
        if (result == 0) {
            // Both ways are valid for doing comparing a objects which are created ie comparableItem
//            return Double.compare(this.comparableItem.price, stock.comparableItem.price);
            // This way does not  chain mehods ie law of demeter, stock should not about price
            return this.comparableItem.compareTo(stock.comparableItem);
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
