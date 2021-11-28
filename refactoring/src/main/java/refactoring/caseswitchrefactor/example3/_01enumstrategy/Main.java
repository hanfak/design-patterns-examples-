package refactoring.caseswitchrefactor.example3._01enumstrategy;

import refactoring.caseswitchrefactor.example3.players.Player;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Player footballPlayer = PlayerTypes.valueOf("FOOTBALL").createPlayer();
    System.out.println("Football player: " + footballPlayer);
    System.out.println();
    Arrays.stream(PlayerTypes.values())
        .map(PlayerTypes::createPlayer)
        .forEach(x -> System.out.println(x.getClass().getSimpleName()));
  }

}
