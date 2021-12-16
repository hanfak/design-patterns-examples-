package gangoffour.visitor.example1;

public class Book implements ItemElement {

  private final int price;
  private final String isbnNumber;
  private final int weight;


  public Book(int cost, String isbn, int weight) {
    this.price = cost;
    this.isbnNumber = isbn;
    this.weight = weight;
  }

  public int getPrice() {
    return price;
  }

  public String getIsbnNumber() {
    return isbnNumber;
  }

  @Override
  public int accept(ShoppingCartVisitor visitor) {
    return visitor.visit(this);
  }

  public int getWeight() {
    return weight;
  }
}
