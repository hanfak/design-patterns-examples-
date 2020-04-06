package designpatterns.prototype.exampleone;


public class BlueColor extends Color {
  private final String colorName;

  public BlueColor() {
    this.colorName = "blue";
  }

  @Override
  void addColor() {
    System.out.println("Blue color added");
  }
}
