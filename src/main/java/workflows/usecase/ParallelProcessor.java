package workflows.usecase;

public interface ParallelProcessor {
  void process(Runnable... o);
}
