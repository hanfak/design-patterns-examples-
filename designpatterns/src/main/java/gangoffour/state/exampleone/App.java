package gangoffour.state.exampleone;

public class App {
  public static void main(String[] args) {

    Package pkg = new Package();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();
  }
}
