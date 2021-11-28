package refactoring.caseswitchrefactor.example3.players;

import refactoring.caseswitchrefactor.example3.old.Type;

public class ClassicPlayer {

  private final Type type;
  private final int delta;

  public ClassicPlayer(Type type, int delta) {
    this.type = type;
    this.delta = delta;
  }

  public Type getType() {
    return type;
  }

  public int getDelta() {
    return delta;
  }

}
