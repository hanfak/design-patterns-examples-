package immutableclass.mutableversion;

public class HobbyMutable {
  public String category;
  public long cost;

  public HobbyMutable(String category, long cost) {
    this.category = category;
    this.cost = cost;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public long getCost() {
    return cost;
  }

  public void setCost(long cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "HobbyMutable{" +
            "category='" + category + '\'' +
            ", cost=" + cost +
            '}';
  }
}
