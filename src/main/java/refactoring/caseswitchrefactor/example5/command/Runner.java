package refactoring.caseswitchrefactor.example5.command;

public class Runner {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int resultAdd = calculator.calculate(new AddCommand(3, 7));
    System.out.println("resultAdd = " + resultAdd);
    int resultMultiply = calculator.calculate(new MultiplyCommand(3, 7));
    System.out.println("resultMultiply = " + resultMultiply);
  }
}
