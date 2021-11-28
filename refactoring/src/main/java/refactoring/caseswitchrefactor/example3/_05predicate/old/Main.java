package refactoring.caseswitchrefactor.example3._05predicate.old;

import refactoring.caseswitchrefactor.example3._05predicate.players.Player;

public class Main {

  public static void main(String[] args) {

    PlayerCreator playerCreator = new PlayerCreator();
    Player tennisPlayer = playerCreator.createPlayer("TENNIS", 5);
    System.out.println("Tennis player: " + tennisPlayer.name());
  }

}