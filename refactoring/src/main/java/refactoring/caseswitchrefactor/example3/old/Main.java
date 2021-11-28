package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.Player;

public class Main {
  public static void main(String[] args) {

    PlayerCreator playerCreator = new PlayerCreator();
    Player tennisPlayer = playerCreator.createPlayer(PlayerTypes.TENNIS);
    System.out.println("Tennis player: " + tennisPlayer);
  }

}
