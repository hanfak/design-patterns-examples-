package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public class Goblin extends AbstractCreature {

  public Goblin() {
    this(new Mass(30.0));
  }

  public Goblin(Mass mass) {
    super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN, mass);
  }
}
