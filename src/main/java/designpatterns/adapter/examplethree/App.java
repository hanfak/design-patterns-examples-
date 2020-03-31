package designpatterns.adapter.examplethree;

public class App {
  public static void main(String[] args) {
    RoundHole roundHole = new RoundHole(5);

    SquarePegAdapter squarePegAdapter;

    for (int i = 6; i < 10; i++) {
      squarePegAdapter = new SquarePegAdapter(i);
      // The client uses (is coupled to) the new interface
      squarePegAdapter.makeFit(roundHole);
    }
  }
}
