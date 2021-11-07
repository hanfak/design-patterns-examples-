package refactoring.caseswitchrefactor.example3._01enumstrategy;

import refactoring.caseswitchrefactor.example3.players.FootballPlayer;
import refactoring.caseswitchrefactor.example3.players.Player;
import refactoring.caseswitchrefactor.example3.players.SnookerPlayer;
import refactoring.caseswitchrefactor.example3.players.TennisPlayer;


//enum type with constant-specific method implementation from effective java
//we can enrich our PlayerTypes with an abstract method, and for each value, we provide an implementation, as follows

public enum PlayerTypes {

  TENNIS {
    @Override
    public Player createPlayer() {
      return new TennisPlayer();
    }
  },
  FOOTBALL {
    @Override
    public Player createPlayer() {
      return new FootballPlayer();
    }
  },
  SNOOKER {
    @Override
    public Player createPlayer() {
      return new SnookerPlayer();
    }
  };

  public abstract Player createPlayer();
}
