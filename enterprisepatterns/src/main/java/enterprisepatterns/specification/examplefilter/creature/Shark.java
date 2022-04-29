package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class Shark extends AbstractCreature {

  public Shark() {
    this(new Mass(500.0));
  }

  public Shark(Mass mass) {
    super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, mass);
  }
}
