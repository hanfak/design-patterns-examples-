package refactoring.caseswitchrefactor.example3._05predicate.better;

import refactoring.caseswitchrefactor.example3._05predicate.players.FootballPlayer;
import refactoring.caseswitchrefactor.example3._05predicate.players.Player;
import refactoring.caseswitchrefactor.example3._05predicate.players.SnookerPlayer;
import refactoring.caseswitchrefactor.example3._05predicate.players.TennisPlayer;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum PlayerTypes {

  TENNIS(
      List.of(
          () -> new TennisPlayer("Rafael Nadal"),
          () -> new TennisPlayer("Roger Federer"),
          () -> new TennisPlayer("Andy Murray")),
      List.of(
          rank -> rank == 1,
          rank -> rank > 1 && rank < 5,
          rank -> rank >= 5 && rank <= 10)
  ),
  FOOTBALL(
      List.of(
          () -> new FootballPlayer("Lionel Messi"),
          () -> new FootballPlayer("Cristiano Ronaldo")),
      List.of(
          rank -> rank == 1 || rank == 2,
          rank -> rank > 2 && rank <= 10)
  ),
  SNOOKER(
      List.of(
          () -> new SnookerPlayer("Ronnie O'Sullivan"),
          () -> new SnookerPlayer("Mark Selby"),
          () -> new SnookerPlayer("John Higgins"),
          () -> new SnookerPlayer("Neil Robertson")),
      List.of(
          rank -> rank == 1,
          rank -> rank == 2,
          rank -> rank > 3 && rank < 7,
          rank -> rank >= 7 && rank <= 10)
  );

  private final List<Supplier<Player>> names;
  private final List<Predicate<Integer>> conditions;

  PlayerTypes(List<Supplier<Player>> names, List<Predicate<Integer>> conditions) {
    this.names = names;
    this.conditions = conditions;
  }

  public static Player supplyPlayer(String playerType, int rank) {

    if (rank < 1 || rank > 10) {
      throw new IllegalArgumentException("Invalid rank: " + rank);
    }

    List<Predicate<Integer>> selectors = PlayerTypes.valueOf(playerType).conditions;

    for (int i = 0; i < selectors.size(); i++) {
      if (selectors.get(i).test(rank)) {
        return PlayerTypes.valueOf(playerType).names.get(i).get();
      }
    }

    throw new IllegalStateException("The enum is corrupted");
  }
}

