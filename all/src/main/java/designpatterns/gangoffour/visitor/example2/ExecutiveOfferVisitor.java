package designpatterns.gangoffour.visitor.example2;

public class ExecutiveOfferVisitor implements IVisitor {
  public int taxToPay;
  public int totalPrice;

  @Override
  public void visit(Book book) {
    int calculatedTax = (book.price * 5) / 100;
    totalPrice += book.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Car car) {
    int calculatedTax = (car.price * 10) / 100;
    totalPrice += car.price + calculatedTax;
    taxToPay += calculatedTax;
  }

  @Override
  public void visit(Wine wine) {
    int calculatedTax = (wine.price * 10) / 100;
    totalPrice += wine.price + calculatedTax;
    taxToPay += calculatedTax;
  }
}
