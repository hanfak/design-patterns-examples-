package designpatterns.adapter.examplethree;

/* The NEW */
class RoundHole {

  private final int radius;

  public RoundHole(int radius) {
    this.radius = radius;
    System.out.println("RoundHole: max SquarePeg is " + radius * Math.sqrt(2));
  }

  public int getRadius() {
    return radius;
  }
}
