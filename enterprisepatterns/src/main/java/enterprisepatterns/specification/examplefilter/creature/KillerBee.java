package enterprisepatterns.specification.examplefilter.creature;

import enterprisepatterns.specification.examplefilter.property.Color;
import enterprisepatterns.specification.examplefilter.property.Mass;
import enterprisepatterns.specification.examplefilter.property.Movement;
import enterprisepatterns.specification.examplefilter.property.Size;

public class KillerBee extends AbstractCreature {

  public KillerBee() {
    this(new Mass(6.7));
  }

  public KillerBee(Mass mass) {
    super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT, mass);
  }
}
