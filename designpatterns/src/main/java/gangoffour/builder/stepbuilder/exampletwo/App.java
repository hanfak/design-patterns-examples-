package gangoffour.builder.stepbuilder.exampletwo;

public class App {
  public static void main(String... args) {
    PaninoStepBuilder.Panino solePanino = PaninoStepBuilder.newBuilder()
            .paninoCalled("sole panino")
            .breadType("baguette")
            .withFish("sole")
            .addVegetable("tomato")
            .addVegetable("lettece")
            .noMoreVegetablesPlease()
            .build();
    System.out.println("solePanino = " + solePanino);

    PaninoStepBuilder.Panino meatPanino = PaninoStepBuilder.newBuilder()
            .paninoCalled("Meat Panino")
            .breadType("Brioche")
            .withMeat("Beef Patty")
            .withCheese("square cheese")
            .addVegetable("Lettuce")
            .addVegetable("Tomato")
            .noMoreVegetablesPlease()
            .build();
    System.out.println("meatPanino = " + meatPanino);
  }
}
