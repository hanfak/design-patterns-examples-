package enterprisepatterns.rulesengine.versionone;

import enterprisepatterns.rulesengine.versionone.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class SummaryOfReviewRulesEngine {

  List<Rule<Book, String>> rules;

  public SummaryOfReviewRulesEngine() {
    rules = new ArrayList<>();
  }

  public String rule(Book book) {
    // Alternate method
//    for(Rule<Book, String> rule : rules) {
//      if (rule.matches(book)){
//        return rule.process(book);
//      }
//    }
//    throw new RuntimeException("No Matching rule found");

    return rules.stream()
            .filter(rule -> rule.matches(book))
            .map(rule -> rule.process(book))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No Matching rule found"));
  }

  public SummaryOfReviewRulesEngine registerRule(Rule<Book, String> rule) {
    rules.add(rule);
    return this;
  }
}
