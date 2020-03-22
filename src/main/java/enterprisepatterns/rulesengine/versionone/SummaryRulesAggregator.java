package enterprisepatterns.rulesengine.versionone;

import enterprisepatterns.rulesengine.versionone.domain.Book;
import enterprisepatterns.rulesengine.versionone.rules.*;

import java.util.ArrayList;
import java.util.List;

public enum SummaryRulesAggregator {
  VERSION_1("description") {
    @Override
    public List<Rule<Book, String>> getRules() {
      List<Rule<Book, String>> rules = new ArrayList<>();
      rules.add(new ShortReviewRule());
      rules.add(new LongReviewRuleWithNoPunctuationRule());
      rules.add(new LongReviewWithCommaRule(new Summarizer()));
      return rules;
    }
  },
  VERSION_2("description") {
    @Override
    public List<Rule<Book, String>> getRules() {
      List<Rule<Book, String>> rules = new ArrayList<>();
      rules.add(new obfuscateAllRule());
      return rules;
    }
  };


  private final String description;

  SummaryRulesAggregator(String description) {
    this.description = description;
  }

  public abstract List<Rule<Book, String>> getRules();
}
