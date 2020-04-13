package designpatterns.gangoffour.visitor.example2;

public class Book extends Product {
  public final int price;

  public Book(int price) {
    this.price = price;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}
