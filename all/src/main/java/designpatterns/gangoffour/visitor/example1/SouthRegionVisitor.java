package designpatterns.gangoffour.visitor.example1;

public class SouthRegionVisitor implements ShoppingCartVisitor {
  @Override
  public int visit(Book book) {
    return calculateFreightForSouthRegion(book.getWeight());
  }

  @Override
  public int visit(Fruit fruit) {
    return calculateFreightForSouthRegion(fruit.getWeight()) + 5;
  }

  private int calculateFreightForSouthRegion(int weight) {
    return (int) Math.ceil(1.1 * weight);
  }
}
