package refactoring.caseswitchrefactor.example3.old;

import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.time.Period;

//
public final class ComputeTennisPlayerStatistics {

  private ComputeTennisPlayerStatistics() {
    throw new AssertionError();
  }

  public static String computeTrend(TennisPlayer tennisPlayer, Period period, String owner, String trend) {
    switch (trend) {
      case "SERVE":
        return Statistics.computeServeTrend(tennisPlayer, period, owner);
      case "FOREHAND":
        return Statistics.computeForehandTrend(tennisPlayer, period, owner);
      case "BACKHAND":
        return Statistics.computeBackhandTrend(tennisPlayer, period, owner);

      default:
        throw new IllegalArgumentException("Invalid trend attribute: " + trend);
    }
  }

}
