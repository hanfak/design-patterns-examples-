package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class Octopus extends AbstractCreature {

  public Octopus() {
    this(new Mass(12.0));
  }

  public Octopus(Mass mass) {
    super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK, mass);
  }
}
