package gangoffour.state.examplefive;

class Player {
  private final String name;
  private int money;

  public Player(String n, int m) {
    name = n;
    money = m;
  }

  public String getName() {
    return name;
  }

  public int getWorth() {
    return money;
  }

  public void debit(int m) {
    money -= m;
  }

  public void credit(int m) {
    money += m;
  }
}
