package designpatterns.prototype.exampleone;

public class BlackColor extends Color {
  private final String colorName;

  public BlackColor() {
    this.colorName = "black";
  }

  @Override
  void addColor() {
    System.out.println("Black color added");
  }
}
