package designpatterns.gangoffour.builder.stepbuilder.exampletwo;

import java.util.ArrayList;
import java.util.List;

public class PaninoStepBuilder implements FirstNameStep, BreadTypeStep, MainFillingStep, CheeseStep, VegetableStep, BuildStep {

  private String name;
  private String breadType;
  private String meat;
  private String fish;
  private String cheese;
  private final List<String> vegetables = new ArrayList<String>();

  private PaninoStepBuilder() {
  }

  public static PaninoStepBuilder newBuilder() {
    return new PaninoStepBuilder();
  }

  public BreadTypeStep paninoCalled(String name) {
    this.name = name;
    return this;
  }

  public MainFillingStep breadType(String breadType) {
    this.breadType = breadType;
    return this;
  }

  public CheeseStep withMeat(String meat) {
    this.meat = meat;
    return this;
  }

  public VegetableStep withFish(String fish) {
    this.fish = fish;
    return this;
  }

  public BuildStep noMoreVegetablesPlease() {
    return this;
  }

  public BuildStep noVegetablesPlease() {
    return this;
  }

  public VegetableStep addVegetable(String vegetable) {
    this.vegetables.add(vegetable);
    return this;
  }

  public VegetableStep noCheesePlease() {
    return this;
  }

  public VegetableStep withCheese(String cheese) {
    this.cheese = cheese;
    return this;
  }

  public Panino build() {
    return new Panino(name, breadType, fish, cheese, meat, vegetables);
  }

  public static class Panino {

    private final String name;
    private final String breadType;
    private final String fish;
    private final String cheese;
    private final String meat;
    private final List<String> vegetables;

    private Panino(String name, String breadType, String fish, String cheese, String meat, List<String> vegetables) {
      this.name = name;
      this.breadType = breadType;
      this.fish = fish;
      this.cheese = cheese;
      this.meat = meat;
      this.vegetables = vegetables;
    }

    @Override
    public String toString() {
      return "Panino [name=" + name + ", breadType=" + breadType + ", fish="
              + fish + ", cheese=" + cheese + ", meat=" + meat
              + ", vegetables=" + vegetables + "]";
    }
  }
}



