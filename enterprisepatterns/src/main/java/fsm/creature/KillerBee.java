package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class KillerBee extends AbstractCreature {

  public KillerBee() {
    this(new Mass(6.7));
  }

  public KillerBee(Mass mass) {
    super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT, mass);
  }
}
