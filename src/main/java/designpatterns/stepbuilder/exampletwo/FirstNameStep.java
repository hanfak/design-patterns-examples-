package designpatterns.stepbuilder.exampletwo;

/**
 * First Builder Step in charge of the Panino name.
 * Next Step available : BreadTypeStep
 */
public interface FirstNameStep {
  BreadTypeStep paninoCalled(String name);
}
