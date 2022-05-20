package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class Shark extends AbstractCreature {

  public Shark() {
    this(new Mass(500.0));
  }

  public Shark(Mass mass) {
    super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT, mass);
  }
}
