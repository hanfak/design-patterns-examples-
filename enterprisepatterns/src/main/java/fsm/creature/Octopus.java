package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class Octopus extends AbstractCreature {

  public Octopus() {
    this(new Mass(12.0));
  }

  public Octopus(Mass mass) {
    super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK, mass);
  }
}
