package enterprisepatterns.workflows.usecase;

import java.math.BigDecimal;

public interface ComplexCalculator {
  BigDecimal calculate(Integer input);
  UseCaseResultModel complexRandomTimeLengthCalculate1(Integer input) throws InterruptedException;
  UseCaseResultModel complexRandomTimeLengthCalculate2(Integer input) throws InterruptedException;
  UseCaseResultModel complexRandomTimeLengthCalculate3(Integer input) throws InterruptedException;

  class UseCaseResultModel {
    public final String result;
    public final Long calculationResult;

    public UseCaseResultModel(String result, Long calculationResult) {
      this.result = result;
      this.calculationResult = calculationResult;
    }
  }
}
