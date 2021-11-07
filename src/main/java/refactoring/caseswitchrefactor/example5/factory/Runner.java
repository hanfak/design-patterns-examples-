package refactoring.caseswitchrefactor.example5.factory;


public class Runner {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int resultAdd = calculator.calculate(3, 7, "add");
    System.out.println("resultAdd = " + resultAdd);
    int resultMultiply = calculator.calculate(3, 7, "multiply");
    System.out.println("resultMultiply = " + resultMultiply);
  }
}
