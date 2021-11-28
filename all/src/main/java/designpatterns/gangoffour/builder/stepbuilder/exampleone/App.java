package designpatterns.gangoffour.builder.stepbuilder.exampleone;

public class App {
  public static void main(String... args) {
    PaninoStepBuilder.Panino solePanino = PaninoStepBuilder.newBuilder()
            .paninoCalled("sole panino")
            .breadType("baguette")
            .fish("sole")
            .addVegetable("tomato")
            .addVegetable("lettece")
            .noMoreVegetablesPlease()
            .build();
    System.out.println("solePanino = " + solePanino);
  }
}
