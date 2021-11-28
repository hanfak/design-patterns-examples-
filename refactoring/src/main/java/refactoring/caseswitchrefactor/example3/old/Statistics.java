package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.time.Period;

public final class Statistics {

  private Statistics() {
    throw new AssertionError("Not supported");
  }

  public static String computeServeTrend(TennisPlayer tennisPlayer, Period period, String owner) {
    return "Serve Trend";
  }

  public static String computeForehandTrend(TennisPlayer tennisPlayer, Period period, String owner) {
    return "Forehand Trend";
  }

  public static String computeBackhandTrend(TennisPlayer tennisPlayer, Period period, String owner) {
    return "Backhand Trend";
  }
}
