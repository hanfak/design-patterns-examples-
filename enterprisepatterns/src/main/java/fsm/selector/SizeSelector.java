package fsm.selector;

import fsm.creature.Creature;
import fsm.property.Size;

/**
 * Size selector.
 */
public class SizeSelector extends AbstractSelector<Creature> {

  private final Size size;

  public SizeSelector(Size s) {
    this.size = s;
  }

  @Override
  public boolean test(Creature t) {
    return t.getSize().equals(size);
  }
}
