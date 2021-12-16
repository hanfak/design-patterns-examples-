package gangoffour.state.examplefour;

import java.io.IOException;
import java.io.InputStreamReader;

public class App {
  public static void main(String[] args) throws IOException {
    InputStreamReader is = new InputStreamReader( System.in );
    Button btn = new Button();
    while (true) {
      System.out.print("Press 'Enter'");
      is.read();
      btn.push();
    }
  }

}
