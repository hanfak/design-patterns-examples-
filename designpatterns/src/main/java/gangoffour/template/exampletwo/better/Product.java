package gangoffour.template.exampletwo.better;

import java.util.List;

public class Product implements Aggregator<Integer, Integer> {
  public Integer evaluate(List<Integer> numbers) {
    return aggregate(numbers, 1, (num, state) -> state = state * num);
  }
}
