package rulesengine.versionone;

public interface Rule<I, O> {
  boolean matches(I input);
  O process(I input);
}
