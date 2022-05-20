package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class Troll extends AbstractCreature {

  public Troll() {
    this(new Mass(4000.0));
  }

  public Troll(Mass mass) {
    super("Troll", Size.LARGE, Movement.WALKING, Color.DARK, mass);
  }
}
