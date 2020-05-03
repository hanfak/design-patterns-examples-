package designpatterns.gangoffour.state.examplefive;

public class App {
  public static void main(String[] args) {
    Player p1 = new Player("Tom", 50);
    Player p2 = new Player("   Dick", 500);
    Property prop = new Property("Boardwalk");
    prop.landOnBy(p1);
    prop.landOnBy(p2);
    prop.landOnBy(p1);
    prop.landOnBy(p2);
    prop.landOnBy(p1);
  }
}
