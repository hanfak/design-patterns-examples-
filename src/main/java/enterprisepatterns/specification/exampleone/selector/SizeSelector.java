package enterprisepatterns.specification.exampleone.selector;

import enterprisepatterns.specification.exampleone.creature.Creature;
import enterprisepatterns.specification.exampleone.property.Size;

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
