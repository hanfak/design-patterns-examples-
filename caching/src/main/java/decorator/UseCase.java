package decorator;

public interface UseCase<T> {
  String execute(T input);
}
