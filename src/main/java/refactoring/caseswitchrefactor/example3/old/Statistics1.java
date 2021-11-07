package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.ClassicPlayer;

public class Statistics1 {
  public int playerEndurance(ClassicPlayer player) {

    int delta = player.getDelta();

    switch (player.getType()) {
      case TENNIS:
        return ComputeEnduranceAlgorithm.basicEndurance(delta)
            + ComputeEnduranceAlgorithm.hardEndurance(delta);
      case FOOTBALL:
        return ComputeEnduranceAlgorithm.hardEndurance(delta)
            * ComputeEnduranceAlgorithm.factorEndurance(delta);
      case SNOOKER:
        return ComputeEnduranceAlgorithm.basicEndurance(delta);

      default:
        throw new IllegalArgumentException("Invalid player type: " + player.getType());
    }
  }
}
