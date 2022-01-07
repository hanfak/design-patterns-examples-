package passbyvalue.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BeanBetter {

  private List<String> collection = new ArrayList<>();

  public BeanBetter(Collection<String> collection) {
    this.collection.addAll(collection);
  }

  public Collection<String> getCollection() {
    return Collections.unmodifiableList(collection);
  }
}
