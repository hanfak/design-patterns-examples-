package designpatterns.gangoffour.builder.exampletwo;

import java.util.List;
import java.util.StringJoiner;

public class CarBuilder {
  private String name;
  private Integer id;
  private List<String> priorOwners;
  private String model;

  public CarBuilder() {}

  public static CarBuilder carBuilder() {
    return new CarBuilder();
  }

  public Car build() {
    return new Car(name, id, priorOwners, model);
  }

  public CarBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public CarBuilder withId(Integer id) {
    this.id = id;
    return this;
  }

  public CarBuilder withPriorOwners(List<String> priorOwners) {
    this.priorOwners = priorOwners;
    return this;
  }

  public CarBuilder withModel(String model) {
    this.model = model;
    return this;
  }

  // Only buider can instantiate this class
  public static class Car {
    private final String name;
    private final Integer id;
    private final List<String> priorOwners;
    private final String model;

    private Car(String name, Integer id, List<String> priorOwners, String model) {
      this.name = name;
      this.id = id;
      this.priorOwners = priorOwners;
      this.model = model;
    }

    // Can use a static factory method here

    @Override
    public String toString() {
      return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
              .add("name='" + name + "'")
              .add("id=" + id)
              .add("priorOwners=" + priorOwners)
              .add("model='" + model + "'")
              .toString();
    }
  }
}
