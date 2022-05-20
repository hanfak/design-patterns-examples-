package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public interface Creature {

  String getName();

  Size getSize();

  Movement getMovement();

  Color getColor();

  Mass getMass();
}
