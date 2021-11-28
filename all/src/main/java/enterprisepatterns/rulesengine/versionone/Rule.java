package enterprisepatterns.rulesengine.versionone;

public interface Rule<I, O> {
  // Matches some rule using the input args. IF true then applies the process
  boolean matches(I input);
  // Returns some processing on the input. Can return something or change something in the input
  // or some dependency passed into the impl of Rule
  O process(I input);
}
