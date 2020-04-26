package enterprisepatterns.specification.exampleone.selector;

import enterprisepatterns.specification.exampleone.creature.Creature;
import enterprisepatterns.specification.exampleone.property.Mass;

/**
 * Mass selector for values greater than the parameter.
 */
public class MassGreaterThanSelector extends AbstractSelector<Creature> {

  private final Mass mass;

  /**
   * The use of a double as a parameter will spare some typing when instantiating this class.
   */
  public MassGreaterThanSelector(double mass) {
    this.mass = new Mass(mass);
  }

  @Override
  public boolean test(Creature t) {
    return t.getMass().greaterThan(mass);
  }
}
