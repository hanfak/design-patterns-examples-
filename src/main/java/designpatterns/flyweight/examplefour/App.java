package designpatterns.flyweight.examplefour;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
  // All player types and weapon (used by getRandPlayerType()
  // and getRandWeapon()
  private static List<String> playerType = Arrays.asList("Terrorist", "CounterTerrorist");
  private static List<String> weapons = Arrays.asList("AK-47", "Maverick", "Gut Knife", "Desert Eagle");

  public static void main(String args[]) {
    /* Assume that we have a total of 10 players in the game. */
    for (int i = 0; i < 10; i++) {
      /* getPlayer() is called simply using the class name since the method is a static one */
      Player player = PlayerFactory.getPlayer(getRandPlayerType());

      /* Assign a weapon chosen randomly uniformly from the weapon array */
      player.assignWeapon(getRandWeapon());

      // Send this player on a mission
      player.mission();
    }
  }

  // Utility methods to get a random player type and weapon
  public static String getRandPlayerType() {
    Random r = new Random();

    // Will return an integer between [0,2)
    int randInt = r.nextInt(playerType.size());

    // return the player stored at index 'randInt'
    return playerType.get(randInt);
  }

  public static String getRandWeapon() {
    Random r = new Random();

    // Will return an integer between [0,5)
    int randInt = r.nextInt(weapons.size());

    // Return the weapon stored at index 'randInt'
    return weapons.get(randInt);
  }
}
