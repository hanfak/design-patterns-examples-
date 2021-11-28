package javalibraries.sorting;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

class ItemNoEquals {
    public final String name;
    public final Double price;
    public final Boolean isAlive;

    public ItemNoEquals(String name, Double price, Boolean isAlive) {
        this.name = name;
        this.price = price;
        this.isAlive = isAlive;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
