package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class Dragon extends AbstractCreature {

  public Dragon() {
    this(new Mass(39300.0));
  }

  public Dragon(Mass mass) {
    super("Dragon", Size.LARGE, Movement.FLYING, Color.RED, mass);
  }
}
