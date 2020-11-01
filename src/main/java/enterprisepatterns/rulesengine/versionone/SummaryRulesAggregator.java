package enterprisepatterns.rulesengine.versionone;

import enterprisepatterns.rulesengine.versionone.domain.Book;
import enterprisepatterns.rulesengine.versionone.rules.*;

import java.util.List;

public enum SummaryRulesAggregator {
  VERSION_1("description") {
    @Override
    public List<Rule<Book, String>> getRules() {
      return List.of(
              new ShortReviewRule(),
              new LongReviewRuleWithNoPunctuationRule(),
              new LongReviewWithCommaRule(new Summarizer())
      );
    }
  },
  VERSION_2("description") {
    @Override
    public List<Rule<Book, String>> getRules() {
      return List.of(new obfuscateAllRule());
    }
  };


  private final String description;

  SummaryRulesAggregator(String description) {
    this.description = description;
  }

  public abstract List<Rule<Book, String>> getRules();
}
