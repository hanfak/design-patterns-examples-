package enterprisepatterns.rulesengine.jeasy.example1;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class LongReviewRuleWithNoPunctuationRule implements Rule {
  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public boolean evaluate(Facts facts) {
    Summary input = facts.get("review");
    return input.value
            .split("\\s+")
            .length > 9;
  }

  @Override
  public void execute(Facts facts) throws Exception {
    Summary summary = facts.get("review");

    String editedSummary = stream(summary.value.split("\\s+"))
            .limit(9)
            .collect(joining(" "))
            + "...";
    facts.put("review", new Summary(editedSummary));
  }

  @Override
  public int compareTo(Rule o) {
    return 0;
  }
}
