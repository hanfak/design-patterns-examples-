package builder.exampleone.old;

import builder.exampleone.Sandwich;
import builder.exampleone.SandwichBuilder;

public class Runner {
  public static void main(String[] args) {
    Sandwich sandwich = new SandwichBuilder("White bread")
            .withMeat("Chicken")
            .noCheese()
            .addVeggie("Lettuce")
            .addVeggie("Tomato")
            .close()
            .create();

    System.out.println("sandwich = " + sandwich);
  }
}
