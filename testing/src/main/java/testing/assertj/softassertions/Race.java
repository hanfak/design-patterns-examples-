package testing.assertj.softassertions;

import static testing.assertj.softassertions.Alignment.EVIL;
import static testing.assertj.softassertions.Alignment.GOOD;
import static testing.assertj.softassertions.Alignment.NEUTRAL;

public enum Race {

  HOBBIT("Hobbit", false, GOOD), MAIA("Maia", true, GOOD), MAN("Man", false, NEUTRAL), ELF("Elf", true, GOOD), DWARF("Dwarf", false, GOOD), ORC("Orc", false, EVIL);

  private final String name;
  public final boolean immortal;
  private Alignment alignment;

  Race(String name, boolean immortal, Alignment alignment) {
    this.name = name;
    this.immortal = immortal;
    this.alignment = alignment;
  }

  public String getName() {
    return name;
  }

  public Alignment getAlignment() {
    return alignment;
  }

  public String getFullname() {
    return immortal ? "immortal " + name : name;
  }

  @Override
  public String toString() {
    return "Race [name=" + name + ", immortal=" + immortal + "]";
  }
}