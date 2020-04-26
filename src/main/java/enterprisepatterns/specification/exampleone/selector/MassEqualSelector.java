package enterprisepatterns.specification.exampleone.selector;

import enterprisepatterns.specification.exampleone.creature.Creature;
import enterprisepatterns.specification.exampleone.property.Mass;

/**
 * Mass selector for values exactly equal than the parameter.
 */
public class MassEqualSelector extends AbstractSelector<Creature> {

  private final Mass mass;

  /**
   * The use of a double as a parameter will spare some typing when instantiating this class.
   */
  public MassEqualSelector(double mass) {
    this.mass = new Mass(mass);
  }

  @Override
  public boolean test(Creature t) {
    return t.getMass().equals(mass);
  }
}
