package fsm.creature;

import fsm.property.Color;
import fsm.property.Mass;
import fsm.property.Movement;
import fsm.property.Size;

public abstract class AbstractCreature implements Creature {

  private String name;
  private Size size;
  private Movement movement;
  private Color color;
  private Mass mass;

  public AbstractCreature(String name, Size size, Movement movement, Color color, Mass mass) {
    this.name = name;
    this.size = size;
    this.movement = movement;
    this.color = color;
    this.mass = mass;
  }

  @Override
  public String toString() {
    return String.format("%s [size=%s, movement=%s, color=%s, mass=%s]",
        name, size, movement, color, mass);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public Movement getMovement() {
    return movement;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Mass getMass() {
    return mass;
  }
}
