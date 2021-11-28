package refactoring.caseswitchrefactor.example3._02commandpattern;

import refactoring.caseswitchrefactor.example3.players.Player;

public class Main {
  public static void main(String[] args) {


    CreatePlayer createCommand = new CreatePlayer();
    Player snookerPlayer = createCommand.createPlayer("SNOOKER");
    System.out.println("Snooker player: " + snookerPlayer);

    CreatePlayer.PLAYERS.values().stream()
        .map(Command::create)
        .forEach(x -> System.out.println(x.getClass().getSimpleName()));
  }
}
