package gangoffour.state.exampletwo;

public class App {
  public static void main(String[] args) {
    Player player = new Player();
    UI ui = new UI(player);
    ui.init();
  }
}
