package designpatterns.stepbuilder.exampletwo;

/**
 * This step is in charge of the BreadType.
 * Next Step available : MainFillingStep
 */
public interface BreadTypeStep {
  MainFillingStep breadType(String breadType);
}
