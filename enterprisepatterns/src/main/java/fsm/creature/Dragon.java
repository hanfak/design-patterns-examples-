package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class Dragon extends AbstractCreature {

  public Dragon() {
    this(new Mass(39300.0));
  }

  public Dragon(Mass mass) {
    super("Dragon", Size.LARGE, Movement.FLYING, Color.RED, mass);
  }
}
