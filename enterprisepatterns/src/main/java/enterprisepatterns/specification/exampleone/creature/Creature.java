package enterprisepatterns.specification.exampleone.creature;

import enterprisepatterns.specification.exampleone.property.Color;
import enterprisepatterns.specification.exampleone.property.Mass;
import enterprisepatterns.specification.exampleone.property.Movement;
import enterprisepatterns.specification.exampleone.property.Size;

public interface Creature {

  String getName();

  Size getSize();

  Movement getMovement();

  Color getColor();

  Mass getMass();
}
