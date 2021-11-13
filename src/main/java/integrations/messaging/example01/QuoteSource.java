package integrations.messaging.example01;

import org.apache.commons.lang3.ArrayUtils;

public class QuoteSource implements Source<String> {

  private static final String[][] quotes = new String[][]{
      new String[]{"a", "a2", "a3"},
      new String[]{"b1", "b2", "b3", "b4"}
  };

  @Override
  public Pair<String, String> getNext() {
    try {
      long sleepTime = (long) (Math.random() * 2000);
      Thread.sleep(sleepTime);
      int chooseQuote = Math.random() < 0.5 ? 0 : 1;
      int index = ((int) (Math.random() * quotes[chooseQuote].length)) % quotes[chooseQuote].length;
      Pair<String, String> stringStringPair = new Pair<>("Quote_" + (chooseQuote + 1), quotes[chooseQuote][index]);
      String[] newArray = ArrayUtils.remove(quotes[chooseQuote], index);
      quotes[chooseQuote] = newArray;
      return stringStringPair;
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new Pair<>(null, null);
  }
}
