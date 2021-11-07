package refactoring.caseswitchrefactor.example5.old;

public class Runner {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int add = calculator.calculate(3, 5, "add");
    System.out.println("add = " + add);
    int mulitply = calculator.calculate(3, 5, "multiply");
    System.out.println("mulitply = " + mulitply);
  }
}
