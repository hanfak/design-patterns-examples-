package visitor.example2;

public class BasicPriceVisitor implements IVisitor {
  public int taxToPay;
  public int totalPrice;

  @Override
  public void visit(Book book) {
    int calculatedTax = (book.price * 10) / 100;
    totalPrice += book.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Car car) {
    int calculatedTax = (car.price * 30) / 100;
    totalPrice += car.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Wine wine) {
    int calculatedTax = (wine.price * 32) / 100;
    totalPrice += wine.price + calculatedTax;
    taxToPay += calculatedTax;
  }
}
