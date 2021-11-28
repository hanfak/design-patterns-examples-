package refactoring.caseswitchrefactor.example3._02commandpattern;

import refactoring.caseswitchrefactor.example3.players.FootballPlayer;
import refactoring.caseswitchrefactor.example3.players.Player;
import refactoring.caseswitchrefactor.example3.players.SnookerPlayer;
import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.util.Map;

// Use of coomand pattern or supplier pattern
// could use supplier interface
public class CreatePlayer {

  public static final Map<String, Command> PLAYERS;

  static {
    PLAYERS = Map.of(
        "TENNIS", TennisPlayer::new,
        "FOOTBALL", FootballPlayer::new,
        "SNOOKER", SnookerPlayer::new);
  }

  public Player createPlayer(String playerType) {
    Command command = PLAYERS.get(playerType);

    if (command == null) {
      throw new IllegalArgumentException("Invalid player type: " + playerType);
    }

    return command.create();
  }
}
