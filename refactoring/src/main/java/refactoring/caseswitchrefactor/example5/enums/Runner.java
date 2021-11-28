package refactoring.caseswitchrefactor.example5.enums;

public class Runner {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int resultAdd = calculator.calculate(3, 4, Operator.valueOf("ADD"));
    System.out.println("resultAdd = " + resultAdd);
    int resultMultiply = calculator.calculate(3, 4, Operator.MULTIPLY);
    System.out.println("resultMultiply = " + resultMultiply);
  }
}
