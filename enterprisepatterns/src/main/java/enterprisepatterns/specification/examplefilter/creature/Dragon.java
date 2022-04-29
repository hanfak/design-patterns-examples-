package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class Dragon extends AbstractCreature {

  public Dragon() {
    this(new Mass(39300.0));
  }

  public Dragon(Mass mass) {
    super("Dragon", Size.LARGE, Movement.FLYING, Color.RED, mass);
  }
}
