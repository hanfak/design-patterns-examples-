package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class Goblin extends AbstractCreature {

  public Goblin() {
    this(new Mass(30.0));
  }

  public Goblin(Mass mass) {
    super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, mass);
  }
}
