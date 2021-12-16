package gangoffour.decorator.functional2;


import java.util.List;
import java.util.function.DoubleUnaryOperator;

import static java.util.function.DoubleUnaryOperator.identity;

public class DecoratorLambda {

  public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
    @Override
    public double applyAsDouble(double grossAnnual) {
      return grossAnnual / 12;
    }
  }

  public static void main(String[] args) {
    double result = new DefaultSalaryCalculator()
        .andThen(Taxes::generalTax)
        .andThen(Taxes::regionalTax)
        .andThen(Taxes::healthInsurance)
        .applyAsDouble(80000.00);
    System.out.println("result = " + result);

    List<DoubleUnaryOperator> taxes = List.of(new DefaultSalaryCalculator(),
        Taxes::generalTax,
        Taxes::regionalTax,
        Taxes::healthInsurance);
    System.out.println(calculateSalary(80000.00, taxes));
  }

  public static double calculateSalary(double annualGross, List<DoubleUnaryOperator> taxes) {
    return taxes.stream()
        .reduce(identity(), DoubleUnaryOperator::andThen)
        .applyAsDouble(annualGross);
  }
}
