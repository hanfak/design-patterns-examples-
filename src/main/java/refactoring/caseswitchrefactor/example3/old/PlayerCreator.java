package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.FootballPlayer;
import refactoring.caseswitchrefactor.example3.players.Player;
import refactoring.caseswitchrefactor.example3.players.SnookerPlayer;
import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

public class PlayerCreator {

  public Player createPlayer(PlayerTypes playerType) {
    switch (playerType) {
      case TENNIS:
        return new TennisPlayer();
      case FOOTBALL:
        return new FootballPlayer();
      case SNOOKER:
        return new SnookerPlayer();

      default:
        throw new IllegalArgumentException("Invalid player type: " + playerType);
    }
  }

}