package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class Goblin extends AbstractCreature {

  public Goblin() {
    this(new Mass(30.0));
  }

  public Goblin(Mass mass) {
    super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, mass);
  }
}
