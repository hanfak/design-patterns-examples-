package workflows.usecase;

import java.util.List;
import java.util.concurrent.Callable;

public interface ParallelProcessor<T> {
  void process(Runnable... o);
  Boolean process2(Runnable... runnables);
  List<T> process(List<Callable<T>> o);
}
