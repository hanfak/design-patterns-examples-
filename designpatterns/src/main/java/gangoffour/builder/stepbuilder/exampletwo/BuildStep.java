package gangoffour.builder.stepbuilder.exampletwo;

/**
 * This is the final step in charge of building the Panino Object.
 * Validation should be here.
 */
public interface BuildStep {
  PaninoStepBuilder.Panino build();
}
