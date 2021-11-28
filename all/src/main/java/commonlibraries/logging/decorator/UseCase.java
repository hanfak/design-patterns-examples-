package commonlibraries.logging.decorator;

public interface UseCase<T> {
  void execute(T input);
}
