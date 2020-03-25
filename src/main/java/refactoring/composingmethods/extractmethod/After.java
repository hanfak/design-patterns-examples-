package refactoring.composingmethods.extractmethod;

public class After {
  void printOwing() {
    String name = "name";
    printBanner();

    // Print details.
    printDetails(name);
  }

  private void printDetails(String name) {
    System.out.println("name: " + name);
    System.out.println("amount: " + getOutstanding());
  }

  private String getOutstanding() {
    return null;
  }

  private void printBanner() {

  }
}
