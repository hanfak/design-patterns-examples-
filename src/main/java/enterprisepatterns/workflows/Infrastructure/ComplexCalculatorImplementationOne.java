package enterprisepatterns.workflows.Infrastructure;

import enterprisepatterns.workflows.usecase.ComplexCalculator;

import java.math.BigDecimal;

public class ComplexCalculatorImplementationOne implements ComplexCalculator {
  @Override
  public BigDecimal calculate(Integer input) {
    return null;
  }

  @Override
  public UseCaseResultModel complexRandomTimeLengthCalculate1(Integer input) throws InterruptedException {
    long result = input * Double.valueOf(Math.random()  * 1000.0).longValue();
    Thread.sleep(result);
    return new UseCaseResultModel("a", input * Double.valueOf(Math.random()).longValue());
  }

  @Override
  public UseCaseResultModel complexRandomTimeLengthCalculate2(Integer input) throws InterruptedException {
    long result = input * Double.valueOf(Math.random() * 1000.0).longValue();
    Thread.sleep(result);
    return new UseCaseResultModel("b", input * Double.valueOf(Math.random()).longValue());
  }

  @Override
  public UseCaseResultModel complexRandomTimeLengthCalculate3(Integer input) throws InterruptedException {
    long result = input * Double.valueOf(Math.random() * 1000.0).longValue();
    Thread.sleep(result);
    return new UseCaseResultModel("c", input * Double.valueOf(Math.random()).longValue());
  }
}
