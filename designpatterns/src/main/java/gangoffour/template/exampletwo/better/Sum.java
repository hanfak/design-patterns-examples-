package gangoffour.template.exampletwo.better;

import java.util.List;

public class Sum implements Aggregator<Integer, Integer> {
  public Integer evaluate(List<Integer> numbers) {
    return aggregate(numbers, 0, (num, state) -> state += num);
  }
}
