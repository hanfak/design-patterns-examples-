package functional.immutableclass.immutableversion;

public final class HobbyImutable {
  private final String category;
  private final long cost;

  public HobbyImutable(String category, long cost) {
    this.category = category;
    this.cost = cost;
  }

  public String getCategory() {
    return category;
  }

  public long getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return "HobbyMutable{" +
            "category='" + category + '\'' +
            ", cost=" + cost +
            '}';
  }
}
