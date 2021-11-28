package enterprisepatterns.rulesengine.jeasy.example1;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class ShortReviewRule implements Rule {

  @Override
  public String getName() {
    return "Short review rule";
  }

  @Override
  public String getDescription() {
    return "Any review of length less than 9 words returns as summary";
  }

  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public boolean evaluate(Facts facts) {
    Summary summary = facts.get("review");
    return summary.value.split("\\s+").length < 9;
  }

  @Override
  public void execute(Facts facts) throws Exception {
    Summary summary = facts.get("review");
    facts.put("review", summary);

  }

  @Override
  public int compareTo(Rule o) {
    return 0;
  }
}
