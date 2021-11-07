package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.AnotherClassicPlayer;

public class Main3 {
  public static void main(String[] args) {

    AnotherClassicPlayer classicPlayer = new AnotherClassicPlayer();
    classicPlayer.register();
    classicPlayer.unregister();
    classicPlayer.unregister();
  }
}
