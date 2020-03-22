package designpatterns.visitor.example2;

public class Car extends Product{
  public final int price;

  public Car(int price) {
    this.price = price;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}
