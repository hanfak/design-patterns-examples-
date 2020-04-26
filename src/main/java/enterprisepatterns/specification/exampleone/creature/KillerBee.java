package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public class KillerBee extends AbstractCreature {

  public KillerBee() {
    this(new Mass(6.7));
  }

  public KillerBee(Mass mass) {
    super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT, mass);
  }
}
