package gangoffour.builder.stepbuilder.exampletwo;

/**
 * This step is in charge of vegetables.
 * Next Step available : BuildStep
 */
public interface VegetableStep {
  BuildStep noMoreVegetablesPlease();

  BuildStep noVegetablesPlease();

  VegetableStep addVegetable(String vegetable);
}
