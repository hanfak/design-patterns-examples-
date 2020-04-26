package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class Troll extends AbstractCreature {

  public Troll() {
    this(new Mass(4000.0));
  }

  public Troll(Mass mass) {
    super("Troll", Size.LARGE, Movement.WALKING, Color.DARK, mass);
  }
}
