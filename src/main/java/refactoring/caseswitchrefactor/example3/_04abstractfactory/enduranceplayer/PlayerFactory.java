package refactoring.caseswitchrefactor.example3._04abstractfactory.enduranceplayer;

import refactoring.caseswitchrefactor.example3.old.Type;
// a switch that can be “hidden” via the Abstract Factory design pattern
// bury the logic in separate objects, rather then in the switch statement
public class PlayerFactory implements AbstractPlayerFactory {

  @Override
  public Player createPlayer(Type type, int delta) {
    switch (type) {
      case TENNIS:
        return new TennisPlayer(type, delta);
      case FOOTBALL:
        return new FootballPlayer(type, delta);
      case SNOOKER:
        return new SnookerPlayer(type, delta);

      default:
        throw new IllegalArgumentException("Invalid player type: " + type);
    }
  }
}
