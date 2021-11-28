package enterprisepatterns.workflows.usecase;

import java.util.List;
import java.util.concurrent.Callable;

public interface RaceConditionProcessor<T> {
  T process(List<Callable<T>> o);
}
