package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.ClassicPlayer;

public class Main2 {
  public static void main(String[] args) {

    Statistics1 statistics = new Statistics1();

    ClassicPlayer player = new ClassicPlayer(Type.TENNIS, 54);
    int tennisPlayerEndurance = statistics.playerEndurance(player);
    System.out.println("Tennis player endurance: " + tennisPlayerEndurance);

  }
}
