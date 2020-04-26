package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class Shark extends AbstractCreature {

  public Shark() {
    this(new Mass(500.0));
  }

  public Shark(Mass mass) {
    super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, mass);
  }
}
