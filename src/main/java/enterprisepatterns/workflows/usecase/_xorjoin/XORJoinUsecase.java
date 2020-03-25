package enterprisepatterns.workflows.usecase._xorjoin;

import enterprisepatterns.workflows.Infrastructure.ComplexCalculatorImplementationOne;
import enterprisepatterns.workflows.Infrastructure.SomeRaceConditionProcessor;
import enterprisepatterns.workflows.usecase.ComplexCalculator;
import enterprisepatterns.workflows.usecase.ComplexCalculator.UseCaseResultModel;
import enterprisepatterns.workflows.usecase.RaceConditionProcessor;

import java.util.Arrays;

public class XORJoinUsecase {

  private final RaceConditionProcessor<UseCaseResultModel> parallelProcessor;
  private final ComplexCalculator calculator;

  public XORJoinUsecase(RaceConditionProcessor<UseCaseResultModel> parallelProcessor, ComplexCalculator calculator) {
    this.parallelProcessor = parallelProcessor;
    this.calculator = calculator;
  }

  public void execute(Integer input) {
    // Example 1 - using callables
    // Step 1 - Start all processors
    UseCaseResultModel process = parallelProcessor.process(Arrays.asList(
            () -> calculator.complexRandomTimeLengthCalculate1(input),
            () -> calculator.complexRandomTimeLengthCalculate2(input),
            () -> calculator.complexRandomTimeLengthCalculate3(input)
            ));
    System.out.println(process.result);

  }


  public static void main(String... args) {
    XORJoinUsecase xorJoinUsecase = new XORJoinUsecase(new SomeRaceConditionProcessor(), new ComplexCalculatorImplementationOne());
    xorJoinUsecase.execute(5);
  }
}
