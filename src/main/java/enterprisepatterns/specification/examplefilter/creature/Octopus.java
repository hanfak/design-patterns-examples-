package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class Octopus extends AbstractCreature {

  public Octopus() {
    this(new Mass(12.0));
  }

  public Octopus(Mass mass) {
    super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK, mass);
  }
}
