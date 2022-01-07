package passbyvalue.example1;

import java.util.Collection;

public class BeanPoor {

  private Collection<String> collection;

  public BeanPoor(Collection<String> collection) {
    this.collection = collection;
  }

  public Collection<String> getCollection() {
    return collection;
  }

  public void setCollection() {
    this.collection = collection;
  }
}