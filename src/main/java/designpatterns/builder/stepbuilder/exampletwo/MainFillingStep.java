package designpatterns.builder.stepbuilder.exampletwo;

/**
 * This step is in charge of setting the main filling (meat or fish).
 * Meat choice : Next Step available : CheeseStep
 * Fish choice : Next Step available : VegetableStep
 */
public interface MainFillingStep {
  CheeseStep withMeat(String meat);

  VegetableStep withFish(String fish);
}
