package gangoffour.prototype.exampleone;

//Prototype
public class App {
  public static void main(String[] args) {
    ColorStore.getColor("blue").addColor();
    ColorStore.getColor("black").addColor();
    ColorStore.getColor("black").addColor();
    ColorStore.getColor("blue").addColor();
  }
}
