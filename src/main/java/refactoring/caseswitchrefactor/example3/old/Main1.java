package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.time.Period;

import static refactoring.caseswitchrefactor.example3.old.ComputeTennisPlayerStatistics.computeTrend;

public class Main1 {
  public static void main(String[] args) {

    String serveTrend = computeTrend(new TennisPlayer(), Period.ZERO, "TENNIS MAGAZINE", "SERVE");
    System.out.println("Serve: " + serveTrend);

  }
}
