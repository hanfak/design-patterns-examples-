package designpatterns.gangoffour.state.examplefour;

public class OFF implements State {
  private static OFF instance = new OFF();

  private OFF() {
  }

  public static State instance() {
    return instance;
  }

  // 6. Override only the necessary methods
  @Override
  public void push(Button b) {
    // 7. The "wrappee" may callback to the "wrapper"
    b.setCurrent(ON.instance());
    System.out.println("   turning ON");
  }
}
