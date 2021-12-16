package gangoffour.strategy.exampleone;

class Item {

  private final String upcCode;
  private final int price;

  public Item(String upc, int cost) {
    this.upcCode = upc;
    this.price = cost;
  }

  public String getUpcCode() {
    return upcCode;
  }

  public int getPrice() {
    return price;
  }

}
