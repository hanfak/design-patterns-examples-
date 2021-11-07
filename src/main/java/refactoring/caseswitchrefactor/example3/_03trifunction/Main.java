package refactoring.caseswitchrefactor.example3._03trifunction;

import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.time.Period;

public class Main {
  public static void main(String[] args) {
    String forehandTrend = FunctionalStatistics.
        computeTrend(new TennisPlayer(), Period.ZERO, "SPORT TV", "FOREHAND");
    System.out.println("Forehand: " + forehandTrend);
  }
}
