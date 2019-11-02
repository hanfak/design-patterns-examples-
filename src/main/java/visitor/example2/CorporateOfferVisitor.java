package visitor.example2;

public class CorporateOfferVisitor implements IVisitor {
  public int taxToPay;
  public int totalPrice;

  @Override
  public void visit(Book book) {
    int calculatedTax = (book.price * 7) / 100;
    totalPrice += book.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Car car) {
    int calculatedTax = (car.price * 20) / 100;
    totalPrice += car.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Wine wine) {
    int calculatedTax = (wine.price * 20) / 100;
    totalPrice += wine.price + calculatedTax;
    taxToPay += calculatedTax;
  }
}
