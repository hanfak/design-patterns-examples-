package refactoring.caseswitchrefactor.example3._04abstractfactory;

import refactoring.caseswitchrefactor.example3._04abstractfactory.enduranceplayer.Player;
import refactoring.caseswitchrefactor.example3._04abstractfactory.enduranceplayer.PlayerFactory;
import refactoring.caseswitchrefactor.example3.old.Type;

public class Main {
  public static void main(String[] args) {
    PlayerFactory playerFactory = new PlayerFactory();
    Player snookerPlayer = playerFactory.createPlayer(Type.SNOOKER, 8);
    int snookerPlayerEndurance  = snookerPlayer.playerEndurance();
    System.out.println("Snooker player endurance: " + snookerPlayerEndurance);
  }
}
