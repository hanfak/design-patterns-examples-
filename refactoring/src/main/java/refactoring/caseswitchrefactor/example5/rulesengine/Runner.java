package refactoring.caseswitchrefactor.example5.rulesengine;

public class Runner {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int calculateAdd = calculator.calculate(new Expression(3, 7, Operator.ADD));
    System.out.println("calculateAdd = " + calculateAdd);
    int calculateMultiply = calculator.calculate(new Expression(3, 7, Operator.MULTIPLY));
    System.out.println("calculateMultiply = " + calculateMultiply);
  }
}
