package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class Troll extends AbstractCreature {

  public Troll() {
    this(new Mass(4000.0));
  }

  public Troll(Mass mass) {
    super("Troll", Size.LARGE, Movement.WALKING, Color.DARK, mass);
  }
}
