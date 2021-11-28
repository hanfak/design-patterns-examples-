package refactoring.caseswitchrefactor.example3._05predicate.better;

import refactoring.caseswitchrefactor.example3._05predicate.players.Player;

public class Main {
 // If we assume that the if statements can be considered Predicate<Integer>,
  public static void main(String[] args) {

    Player footballPlayer = PlayerSupplier.supplyPlayer("FOOTBALL", 6);
    System.out.println("Football player: " + footballPlayer.name());

    Player snookerPlayer = PlayerTypes.supplyPlayer("SNOOKER", 10);
    System.out.println("Snooker player: " + snookerPlayer.name());
  }


}