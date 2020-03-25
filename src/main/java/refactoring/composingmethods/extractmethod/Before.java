package refactoring.composingmethods.extractmethod;

public class Before {
  void printOwing() {
    String name = "name";
    printBanner();

    // Print details.
    System.out.println("name: " + name);
    System.out.println("amount: " + getOutstanding());
  }

  private String getOutstanding() {
    return null;
  }

  private void printBanner() {

  }
}
