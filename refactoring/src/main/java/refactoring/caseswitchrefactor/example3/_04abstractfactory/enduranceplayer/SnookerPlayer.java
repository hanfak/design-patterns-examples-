package refactoring.caseswitchrefactor.example3._04abstractfactory.enduranceplayer;

import refactoring.caseswitchrefactor.example3.old.ComputeEnduranceAlgorithm;
import refactoring.caseswitchrefactor.example3.old.Type;

public class SnookerPlayer extends Player {

  public SnookerPlayer(Type type, int delta) {
    super(type, delta);
  }

  @Override
  public int playerEndurance() {
    return ComputeEnduranceAlgorithm.basicEndurance(this.getDelta());
  }
}

