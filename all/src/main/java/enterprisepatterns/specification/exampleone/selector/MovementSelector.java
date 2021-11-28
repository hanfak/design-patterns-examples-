package enterprisepatterns.specification.exampleone.selector;

import enterprisepatterns.specification.exampleone.creature.Creature;
import enterprisepatterns.specification.exampleone.property.Movement;

public class MovementSelector extends AbstractSelector<Creature> {

  private final Movement movement;

  public MovementSelector(Movement m) {
    this.movement = m;
  }

  @Override
  public boolean test(Creature t) {
    return t.getMovement().equals(movement);
  }
}
