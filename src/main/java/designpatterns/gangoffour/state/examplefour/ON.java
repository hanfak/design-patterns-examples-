package designpatterns.gangoffour.state.examplefour;

public class ON implements State {
  private static ON instance = new ON();

  private ON() {}

  public static State instance() {
    return instance;
  }
  @Override
  public void push(Button b) {
    b.setCurrent(OFF.instance());
    System.out.println("   turning OFF");
  }
}
