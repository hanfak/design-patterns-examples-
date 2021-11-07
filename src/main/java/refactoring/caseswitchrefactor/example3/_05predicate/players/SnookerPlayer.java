package refactoring.caseswitchrefactor.example3._05predicate.players;

public class SnookerPlayer implements Player {

  private final String name;

  public SnookerPlayer(String name) {
    this.name = name;
  }

  @Override
  public String name() {
    return name;
  }
}
