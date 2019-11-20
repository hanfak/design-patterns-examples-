package effectivejava.immutable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {
  private final Date date;

  private final List<OrderItem> items;

  private Order(Date date, List<OrderItem> items) {
    this.date = date;
    this.items = items;
  }

  public static Order of(Date date, List<OrderItem> items) {
    Objects.requireNonNull(date);
    // creating a defensive copy of date
    // but will need to do checking of date in the constructor
    return new Order(new Date(date.getTime()), new ArrayList<>(items));
  }

  public Date getDate() {
    return new Date(date.getTime());
  }

  public void addItem(OrderItem item) {
    // if want to modify the items, their should be api to do this, with validation if necessary
  }

  public List<OrderItem> getItems() {
    return ImmutableList.copyOf(items); // to stop outside objects modifier the list, as only this class should do this

  }
}

class OrderItem {
}
