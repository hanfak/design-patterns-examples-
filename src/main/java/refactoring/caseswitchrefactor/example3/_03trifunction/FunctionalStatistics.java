package refactoring.caseswitchrefactor.example3._03trifunction;

import refactoring.caseswitchrefactor.example3.old.Statistics;
import refactoring.caseswitchrefactor.example3.players.TennisPlayer;

import java.time.Period;
import java.util.HashMap;
import java.util.Map;

// each case invokes a static method that receives three arguments and returns a String.
// In such cases, a Supplier is not helpful.
// Because we have more than two arguments, we cannot rely on BiFunction either
public final class FunctionalStatistics {

  private FunctionalStatistics() {
    throw new AssertionError();
  }

  private static final Map<String, TriFunction<TennisPlayer, Period, String, String>> STATISTICS = new HashMap<>();

  static {
    STATISTICS.put("SERVE", Statistics::computeServeTrend);
    STATISTICS.put("FOREHAND", Statistics::computeForehandTrend);
    STATISTICS.put("BACKHAND", Statistics::computeBackhandTrend);
  }

  public static String computeTrend(TennisPlayer tennisPlayer, Period period, String owner, String trend) {

    TriFunction<TennisPlayer, Period, String, String> function = STATISTICS.get(trend);

    if (function == null) {
      throw new IllegalArgumentException("Invalid trend type: " + trend);
    }

    return function.apply(tennisPlayer, period, owner);
  }
}