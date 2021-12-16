package gangoffour.builder.exampleone;

import java.util.List;
import java.util.function.Function;

public class Sandwich {
  private final String bread;
  private final String meat;
  private final String cheese;
  private final List<String> vegetables;

  public Sandwich(String bread, String meat, String cheese, List<String> vegetables) {
    this.bread = bread;
    this.meat = meat;
    this.cheese = cheese;
    this.vegetables = vegetables;
  }

  public String getBread() {
    return bread;
  }

  public String getMeat() {
    return meat;
  }

  public String getCheese() {
    return cheese;
  }

  public List<String> getVegetables() {
    return vegetables;
  }

  @Override
  public String toString() {
    return "Sandwich{" +
            "bread='" + bread + '\'' +
            ", meat='" + meat + '\'' +
            ", cheese='" + cheese + '\'' +
            ", vegetables=" + vegetables +
            '}';
  }
 //
  public static Sandwich make(String bread, Function<ChooseBreadStep, CloseStep> configuration) {
    return configuration.andThen(CloseStep::create).apply(new SandwichBuilder(bread));
  }
}
