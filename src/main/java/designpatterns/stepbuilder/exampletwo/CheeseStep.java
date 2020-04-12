package designpatterns.stepbuilder.exampletwo;

/**
 * This step is in charge of the cheese.
 * Next Step available : VegetableStep
 */
public interface CheeseStep {
  VegetableStep noCheesePlease();

  VegetableStep withCheese(String cheese);
}
