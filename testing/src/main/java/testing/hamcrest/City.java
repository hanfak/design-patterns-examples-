package testing.hamcrest;

public class City extends Location {
  private final String name;
  private final String state;

  public City(String name, String state) {
    this.name = name;
    this.state = state;
  }

  @Override
  public String toString() {
    if (this.name == null && this.state == null) return null;
    return "[" +
            "Name: " +
            this.name +
            ", " +
            "State: " +
            this.state +
            "]";
  }
}
