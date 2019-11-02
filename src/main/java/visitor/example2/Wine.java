package visitor.example2;

public class Wine extends Product{
  public final int price;

  public Wine(int price) {
    this.price = price;
  }

  @Override
  public void accept(IVisitor visitor) {
    visitor.visit(this);
  }
}
