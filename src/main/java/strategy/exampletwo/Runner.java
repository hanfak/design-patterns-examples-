package strategy.exampletwo;

import java.math.BigDecimal;

public class Runner {
  public static void main(String[] args) {
    Runner runner = new Runner();
    System.out.println("Common immpl of strategy\n");
    Discounter discounter = new EasterDiscounter();
    BigDecimal discountedValue = discounter
            .applyDiscount(BigDecimal.valueOf(100));
    System.out.println("Easter discountedValue = " + discountedValue);


    discounter = new ChristmasDiscounter();
    BigDecimal discountedValue2 = discounter
            .applyDiscount(BigDecimal.valueOf(100));
    System.out.println("Christmas discountedValue = " + discountedValue2);
    System.out.println();


    System.out.println("Java 8 functional way of implemnenting strategy\n");
    System.out.println("No need to create the classes for EasterDiscounter or ChristmasDiscounter");
    Discounter lambdaEasterDiscounter = amount -> amount.multiply(BigDecimal.valueOf(0.5));
    // extract for more complex functional bodies
    Discounter lambdaChristmasDiscounter = runner::calculateDiscount;

    BigDecimal discountEasterValueFromLambda = lambdaEasterDiscounter.applyDiscount(BigDecimal.valueOf(100));
    System.out.println("discountEasterValueFromLambda = " + discountEasterValueFromLambda);
    BigDecimal discountChristmassValueFromLambda = lambdaChristmasDiscounter.applyDiscount(BigDecimal.valueOf(100));
    System.out.println("discountChristmassValueFromLambda = " + discountChristmassValueFromLambda);

  }

  private BigDecimal calculateDiscount(BigDecimal amount) {
    return amount.multiply(BigDecimal.valueOf(0.9));
  }
}
