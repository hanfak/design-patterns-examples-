package gangoffour.builder.exampletwo;

public class App {
  public static void main(String... args) {
    CarBuilder.Car fiat = CarBuilder.carBuilder()
            .withId(1234)
            .withModel("fiat")
            .build();
    System.out.println("fiat = " + fiat);
  }
}
