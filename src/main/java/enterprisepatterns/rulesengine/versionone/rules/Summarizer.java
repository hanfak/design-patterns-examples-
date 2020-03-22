package enterprisepatterns.rulesengine.versionone.rules;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Summarizer {
  public List<String> createSummaryOfNWordsList(int numberOfWords, String review) {
    return stream(review
            .split("\\s+"))
            .limit(numberOfWords)
            .collect(toList());
  }
}
